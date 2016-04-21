package org.stjs.bridge.react.redux;

import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.react.internal.ReactComponent;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge
abstract class StoreProvider extends Component<ProviderProps, State> {

	public StoreProvider(ProviderProps props) {
		super(props);
	}
}
