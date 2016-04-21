package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.internal.Props;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function2;

@FunctionalInterface
@STJSBridge
public interface StateToPropsWithOwnPropsFunction<S, P extends Props> extends Function2<S, P, P> {
}
