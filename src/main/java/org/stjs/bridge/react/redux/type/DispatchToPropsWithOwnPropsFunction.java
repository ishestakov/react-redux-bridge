package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.redux.api.Action;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function1;
import org.stjs.javascript.functions.Function2;

@STJSBridge
@FunctionalInterface
public interface DispatchToPropsWithOwnPropsFunction<P extends Props> extends Function2<Function1<Action, Object>, P, P> {
}
