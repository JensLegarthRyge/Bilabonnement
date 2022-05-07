package com.example.bilabonnement.services;

public class EmailValidator {
    public static boolean isEmailValid(String email){
        //Checks if email contains a "@".
        if (countAmountOfSymbolInString(email, '@') == 1){
            String[] splittetMail = email.split("@");

            //Checks if both prefix and domain is valid as an email
            if(isPrefixValid(splittetMail[0]) && isDomainValid(splittetMail[1])){
                return true;
            }
        }
        return false;
    }

    //Checks whether a prefix is valid or not.
    //A prefix can contain numbers letters or these special characters: ". - _"
    //If one of the special characters occur, there must be atleast 1 number or letter before and after.
    private static boolean isPrefixValid(String prefix){
        if(prefix.matches("[a-zA-Z0-9._\\-]+")){
            String[] splittetPrefix = prefix.split("");
            for (int i = 0; i < prefix.length(); i++) {
                if(splittetPrefix[i].matches("[._\\-]+")){
                    try{
                        boolean test = (splittetPrefix[i - 1].matches("[a-zA-Z0-9]+")) && (splittetPrefix[i + 1].matches("[a-zA-Z0-9]+"));
                    }
                    catch (Exception e){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    //Method that checks wether an emaildomain is valid or not.
    //A domain must only contain 1 punctuation and letters or numbers on each side of that punctuation.
    private static boolean isDomainValid(String domain){
        if(countAmountOfSymbolInString(domain, '.') == 1){
            String[] splittetDomain = domain.split("\\.");
            try {
                if (containsOnlyLetters(splittetDomain[0]) && containsOnlyLetters(splittetDomain[1])) {
                    return true;
                }
            }
            catch (Exception e){
            }
        }
        return false;
    }

    //Method that checks wether a string contains something other than letters.
    private static boolean containsOnlyLetters(String test){
        if(test.matches("[a-zA-Z]+")){
            return true;
        }else {
            return false;
        }
    }

    //Method that counts the amount of a specific character
    private static int countAmountOfSymbolInString(String word, char symbol){
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol){
                counter++;
            }
        }
        return counter;
    }
}
