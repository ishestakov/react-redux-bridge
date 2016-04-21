package org.stjs.bridge.react.redux;

import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.react.internal.ReactClassInterface;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge
public final class Connected extends Component<Props, State> {

	public Connected(Props props) {
		super(props);
	}

	/**
	 * Returns the wrapped component instance. Only available if you pass { withRef: true } as part of the connect()’s fourth options argument.
	 * @param <T> The type of wrapped component.
	 * @return the wrapped component instance or null.
	 */
	public static native <T> T getWrappedInstance();

	@Override
	public native ReactElement<?> render();
}
