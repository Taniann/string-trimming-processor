package com.tn.app;

import com.tn.magic.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Trimmed
@Service
public class StringUtilsService {

    public String concat(String str1, String str2) {
        return str1 + str2;
    }

    public String addWhiteSpaces(String str) {
        return "     " + str;
    }
}
