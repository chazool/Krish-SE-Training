package com.chazool.capitalization.service;

import java.io.IOException;

public interface EnglishCharacter {

    static final  char[] englishLatter = {'A' ,'B' ,'C' ,'D' ,'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public  char[] getCapitalLatter() throws IOException;



}
