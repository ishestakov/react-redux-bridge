package org.stjs.bridge.react.redux.type;

import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.redux.api.Action;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function1;

@STJSBridge
@FunctionalInterface
public interface DispatchToProps<P extends Props, R> extends Function1<Function1<Action, R>, P> {
}
