package com.tn.app;

import com.tn.magic.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Trimmed
@Service
public class IntUtilsService {

    public int add(int int1, int int2) {
        return int1 + int2;
    }
}
