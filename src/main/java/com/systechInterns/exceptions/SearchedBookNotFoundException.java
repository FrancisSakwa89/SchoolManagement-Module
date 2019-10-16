package com.systechInterns.exceptions;


public class SearchedBookNotFoundException extends Exception {
        public  SearchedBookNotFoundException() {
            super("Book looking for is not found...");
        }
    }

