package com.fun.script.lang;

import com.fun.script.FunScript;

import java.util.HashMap;
import java.util.Map;

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

    public void debug()
    {
        for(Map.Entry<FunScriptVal, FunScriptVal> kvp : this.values.entrySet())
        {
            FunScript.debugLog("FunScriptTable.debug()", kvp.getKey().stringVal + ", " + kvp.getValue().numberVal);
        }
    }

    public boolean containsKey(FunScriptVal val)
    {
        return this.values.containsKey(val);
    }
}
