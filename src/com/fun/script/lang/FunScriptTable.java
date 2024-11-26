package com.fun.script.lang;

import java.util.HashMap;

public class FunScriptTable
{
    private HashMap<FunScriptVal, FunScriptVal> values;

    public FunScriptTable()
    {
        this.values = new HashMap<>();
    }

    public void put(FunScriptVal key, FunScriptVal val)
    {
        this.values.put(key, val);
    }

    public FunScriptVal get(FunScriptVal key)
    {
        return this.values.get(key);
    }
}
