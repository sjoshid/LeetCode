package com.practice;

import java.util.HashSet;
import java.util.Set;

/*Every email consists of a local name and a domain name, separated by the @ sign.

        For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

        Besides lowercase letters, these emails may contain '.'s or '+'s.

        If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

        If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

        Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



        Example 1:

        Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        Output: 2
        Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

        WORKS CORRECTLY*/
public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqEmails = new HashSet<>(emails.length);

        for(String email: emails) {
            int indexOfPlus = email.indexOf("+");
            int indexOfAt = email.indexOf("@");

            if(indexOfPlus != -1) {
                String beforePlus = email.substring(0, indexOfPlus);
                String noDots = beforePlus.replaceAll("\\.","");
                String fromAt = email.substring(indexOfAt);
                String parsedEmail = noDots.concat(fromAt);
                uniqEmails.add(parsedEmail);
            } else {
                String beforeAt = email.substring(0, indexOfAt);
                String noDots = beforeAt.replaceAll("\\.","");
                String fromAt = email.substring(indexOfAt);
                String parsedEmail = noDots.concat(fromAt);
                uniqEmails.add(parsedEmail);
            }
        }

        return uniqEmails.size();
    }
}
