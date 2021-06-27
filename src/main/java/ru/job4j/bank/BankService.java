package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковской системы,
 * включая в себя методы по добавлению в базу данных банка пользователя, его счет,
 * поиска по номеру паспорта, по реквизитам счета,
 * а также осуществление перевода денег по реквизитам пользователей
 * @author Eugene Emelyanov
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение данных пользователя осуществляется в коллекции типа HashMap.
     * Это БД банка
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает данные пользователя и добавляет их в БД,
     * если такого пользователя там еще не существует
     * @param user данные конкретного пользователя
     */
    public void addUser(User user) {
        List<Account> acc = new ArrayList<>();
        users.putIfAbsent(user, acc);
    }

    /**
     * Метод добавляет данные о счете конкретного пользователя,
     * реализуя это действие по номеру паспорта пользователя
     * (осуществляется проверка на null и дубликат счета)
     * @param passport данные паспорта пользователя
     * @param account счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccount = users.get(user.get());
            if (!(userAccount.contains(account))) {
                userAccount.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по данным его паспорта
     * @param passport данные паспорта пользователя
     * @return возвращает данные пользователя, или null, если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск счета пользователя по реквизитам
     * @param passport данные паспорта пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает данные счета пользователя, если таковой найден в базе данных,
     * иначе возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(e -> e.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод выполняет транзакцию между счетами двух пользователей
     * @param srcPassport паспортные данные владельца счета, с которого списываются деньги
     * @param srcRequisite реквизиты счета, с которого списываются деньги
     * @param destPassport паспортные данные пользователя, на чей счет зачисляются деньги
     * @param destRequisite реквизиты счета, на который зачисляются деньги
     * @param amount сумма транзакции
     * @return true при успешной транзакции, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}