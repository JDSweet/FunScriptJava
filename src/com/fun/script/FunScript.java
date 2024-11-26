package com.fun.script;

import com.fun.script.lang.FunScriptVal;

public class FunScript
{
    public static FunScriptVal coerceJavaToFS(Object obj)
    {
        return new FunScriptVal(obj);
    }

    public static FunScriptVal coerceFloatToNumber(float number)
    {
        return new FunScriptVal(number);
    }
}
