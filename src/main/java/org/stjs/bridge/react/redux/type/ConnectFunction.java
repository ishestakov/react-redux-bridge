package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.redux.Connected;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function1;

@STJSBridge
@FunctionalInterface
/**
 * Connects a React component to a Redux store.
 * It does not modify the component class passed to it.
 * Instead, it returns a new, connected component class, for you to use.
 */ public interface ConnectFunction<T> extends Function1<Class<T>, Class<Connected>> {
}
