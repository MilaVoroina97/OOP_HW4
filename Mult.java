import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BinaryOperator;

public class Mult implements BinaryOperator<Object>{

    @Override
    public Object apply(Object partialSum, Object element) {
        if(partialSum instanceof Number) {
            if(element instanceof Number) {
                if(partialSum instanceof Integer)
                    return (Integer) partialSum * ((Number) element).intValue();
                if(partialSum instanceof Long)
                    return (Long) partialSum * ((Number) element).longValue();
                if(partialSum instanceof BigInteger)
                    return ((BigInteger) partialSum).add(BigInteger.valueOf(((Number) element).longValue()));
                if(partialSum instanceof Float)
                    return (Float) partialSum * ((Number) element).floatValue();
                if(partialSum instanceof Double)
                    return (Double) partialSum * ((Number) element).doubleValue();
                if(partialSum instanceof BigDecimal)
                    return ((BigDecimal) partialSum).add(BigDecimal.valueOf(((Number) element).doubleValue()));
                else
                    throw new NumberFormatException("Unknown number type for partialSum: " + partialSum.getClass());
            }
            else {
                if(partialSum instanceof Integer)
                    return (Integer) partialSum * Integer.parseInt(element.toString());
                if(partialSum instanceof Long)
                    return (Long) partialSum * Long.parseLong(element.toString());
                if(partialSum instanceof BigInteger)
                    return ((BigInteger) partialSum).add(new BigInteger(element.toString()));
                if(partialSum instanceof Float)
                    return (Float) partialSum * Float.parseFloat(element.toString());
                if(partialSum instanceof Double)
                    return (Double) partialSum * Double.parseDouble(element.toString());
                if(partialSum instanceof BigDecimal)
                    return ((BigDecimal) partialSum).add(new BigDecimal(element.toString()));
                if(partialSum instanceof String)
                    return (String) partialSum + element.toString();
                else
                    throw new NumberFormatException("Unknown number type for partialSum: " + partialSum.getClass());
            }
        }
        throw new NumberFormatException("partialSum " + partialSum + " must be of type java.lang.Number but found " + partialSum.getClass());
    }
}
