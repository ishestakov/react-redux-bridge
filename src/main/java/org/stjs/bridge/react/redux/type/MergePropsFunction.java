package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.internal.Props;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function2;

@FunctionalInterface
@STJSBridge
public interface MergePropsFunction<S extends Props, D extends Props, R extends Props> extends Function2<S, D, R> {
}
