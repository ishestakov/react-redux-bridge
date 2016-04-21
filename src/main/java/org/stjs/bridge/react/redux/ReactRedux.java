package org.stjs.bridge.react.redux;

import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.react.internal.ReactClassInterface;
import org.stjs.bridge.react.internal.State;
import org.stjs.bridge.react.redux.type.ConnectFunction;
import org.stjs.bridge.react.redux.type.DispatchToProps;
import org.stjs.bridge.react.redux.type.DispatchToPropsWithOwnPropsFunction;
import org.stjs.bridge.react.redux.type.StateToPropsFunction;
import org.stjs.bridge.react.redux.type.StateToPropsWithOwnPropsFunction;
import org.stjs.bridge.redux.api.Action;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;
import org.stjs.javascript.functions.Function1;
import org.stjs.javascript.functions.Function2;

@STJSBridge(sources = "react-redux.min.js")
public final class ReactRedux {
	public static Class<Component<ProviderProps, State>> Provider;

	/**
	 * Connects a React component to a Redux store.
	 * It does not modify the component class passed to it.
	 * Instead, it returns a new, connected component class, for you to use.
	 * Returns the function which will return the component which in turn will just inject dispatch property to the passed component after function invocation.
	 * The component will not be subscribed to the store
	 *
	 * @return Connected component which will wrap the passed component instance
	 */
	public static native <T extends ReactClassInterface> ConnectFunction<T> connect();

	/**
	 * Return the function which will wrap passed component and pass properties from the store which will be retrieved after calling mapStateToProps function.
	 * In addition a dispatch property will be passed down as dispatch property.
	 * Connects a React component to a Redux store.
	 * It does not modify the component class passed to it.
	 * Instead, it returns a new, connected component class, for you to use.
	 *
	 * @param mapStateToProps the function to map state retrieved from the store to component's properties
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(
			StateToPropsFunction<?, P> mapStateToProps);

	/**
	 * Connects a React component to a Redux store.
	 * It does not modify the component class passed to it.
	 * Instead, it returns a new, connected component class, for you to use.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param <P>             the props of the wrapped component
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsWithOwnPropsFunction<?, P> mapStateToProps);

	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsFunction<?, P> mapStateToProps,
			DispatchToProps<P, ?> mapDispatchToProps);

	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsWithOwnPropsFunction<?, P> mapStateToProps,
			DispatchToProps<P, ?> mapDispatchToProps);

	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsWithOwnPropsFunction<?, P> mapStateToProps,
			DispatchToPropsWithOwnPropsFunction<P, ?> mapDispatchToProps);
}
