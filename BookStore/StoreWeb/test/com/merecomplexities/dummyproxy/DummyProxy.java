package com.merecomplexities.dummyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 */
@SuppressWarnings({"unchecked"})
public class DummyProxy
{
    public static <T> T dummy(Class<T> aClass, Object partialImplementation)
    {
        return dummy(aClass, new Handler(partialImplementation));
    }

    public static <T> T dummyReturningNullOnUnrecognised(Class<T> aClass, Object partialImplementation)
    {

        return dummy(aClass, new Handler(partialImplementation).returnNullOnUnrecognised());
    }

    private static <T>T dummy(Class<T> aClass, Handler handler) {return (T) Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, handler);}


    private static class Handler implements InvocationHandler
    {
        private Object partialImplementation;
        private boolean returnNullOnUnrecognised = false;

        public Handler(Object partialImplementation)
        {
            this.partialImplementation = partialImplementation;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            try
            {
                return findMethod(method).invoke(partialImplementation, args);
            }
            catch (NoSuchMethodException e)
            {
                if (returnNullOnUnrecognised) return null;
                throw new UnsupportedOperationException(
                        method.getName() + ": " + Arrays.asList(method.getParameterTypes()));
            }
            catch (InvocationTargetException e)
            {
                throw e.getTargetException();
            }
        }

        Handler returnNullOnUnrecognised()
        {
            returnNullOnUnrecognised = true;
            return this;
        }

        private Method findMethod(Method method) throws NoSuchMethodException
        {
            return partialImplementation.getClass().getMethod(method.getName(), method.getParameterTypes());
        }
    }
}
