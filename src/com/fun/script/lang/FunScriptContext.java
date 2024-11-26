package com.fun.script.lang;

import com.fun.script.FunScript;

public class FunScriptContext
{
    public FunScriptTable globalTable;

    public FunScriptContext()
    {
        this.globalTable = new FunScriptTable();
    }

    // Future debugging to do... What's weird is:
    // The values print correctly in the debug statement, but at some point between the printing and their actual insertion into the global table,
    // there is a bug.
    // I don't know exactly what is going on, but basically, the global table seems to think that some values are
    // already stored in it, even though they aren't.
    public void addVariable(FunScriptVal key, FunScriptVal val)
    {
        FunScript.debugLog("FunScriptContext.addVariable() debug", "Variable " + key.stringVal + " set to " + val.numberVal);
        if(!globalTable.containsKey(key))
            this.globalTable.put(key, val);
        else
            FunScript.debugLog("FunScriptContext.addVariable() debug", "Variable " + key.stringVal + " is already present.");
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
