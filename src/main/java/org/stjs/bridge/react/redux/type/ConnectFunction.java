package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.redux.Connected;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function1;

@STJSBridge
@FunctionalInterface
public interface ConnectFunction<T> extends Function1<Class<T>, Class<Connected>> {
}
