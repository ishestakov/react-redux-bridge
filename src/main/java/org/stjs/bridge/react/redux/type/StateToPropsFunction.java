package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.internal.Props;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function1;

@STJSBridge
@FunctionalInterface
public interface StateToPropsFunction<S, P extends Props> extends Function1<S, P> {
}
