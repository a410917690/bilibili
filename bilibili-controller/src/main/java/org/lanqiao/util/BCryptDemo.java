package org.lanqiao.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptDemo {
    public static void main(String[] args) {
// Hash a password for the first time
        String password = "123";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String candidate = "123";
        if (BCrypt.checkpw(candidate, hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}
