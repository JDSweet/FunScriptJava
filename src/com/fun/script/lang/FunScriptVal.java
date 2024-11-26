package com.fun.script.lang;

import java.util.Objects;

public class FunScriptVal
{
    public float numberVal;
    public String stringVal;
    public Object objVal;

    public FunScriptVal(float numberVal)
    {
        this.numberVal = numberVal;
        this.stringVal = "" + numberVal;
        this.objVal = stringVal;
    }

    public FunScriptVal(String stringVal)
    {
        this.numberVal = (float)stringVal.hashCode();
        this.stringVal = stringVal;
        this.objVal = stringVal;
    }

    public FunScriptVal(Object obj)
    {
        this.numberVal = 0.0f;
        if(obj instanceof FunScriptVal)
        {
            this.numberVal = ((FunScriptVal) obj).numberVal;
            this.stringVal = ((FunScriptVal) obj).stringVal;
            this.objVal = ((FunScriptVal) obj).objVal;
        }
        else
        {
            this.objVal = obj;
            this.stringVal = objVal.toString();
            this.numberVal = (float)obj.hashCode();
        }
    }

    @Override
    public boolean equals(Object other)
    {
        if(other instanceof FunScriptVal)
        {
            FunScriptVal realOther = (FunScriptVal) other;
            return realOther.numberVal == this.numberVal || realOther.objVal.equals(objVal) || realOther.stringVal.equals(stringVal);
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(stringVal, objVal, numberVal);
    }
}
