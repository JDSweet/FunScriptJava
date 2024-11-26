package com.fun.script.lang;

import com.fun.script.FunScript;

public class FunScriptContext
{
    public FunScriptTable globalTable;

    public FunScriptContext()
    {
        this.globalTable = new FunScriptTable();
    }

    public void addVariable(FunScriptVal key, FunScriptVal val)
    {
        FunScript.debugLog("FunScriptContext.addVariable() debug", "Variable " + key.stringVal + " set to " + val.numberVal);
        this.globalTable.put(key, val);
    }

    public FunScriptVal getVariableByName(String name)
    {
        return globalTable.get(new FunScriptVal(name));
    }

    public void debugGlobalTable()
    {
        globalTable.debug();
    }
}
