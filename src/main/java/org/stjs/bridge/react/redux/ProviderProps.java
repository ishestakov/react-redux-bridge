package org.stjs.bridge.react.redux;

import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.redux.api.Store;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.SyntheticType;

@STJSBridge
@SyntheticType
public class ProviderProps extends Props {
	public Store store;
}
