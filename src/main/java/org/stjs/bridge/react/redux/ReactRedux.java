package org.stjs.bridge.react.redux;

import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.react.internal.ReactClassInterface;
import org.stjs.bridge.react.internal.State;
import org.stjs.bridge.react.redux.type.ConnectFunction;
import org.stjs.bridge.react.redux.type.DispatchToProps;
import org.stjs.bridge.react.redux.type.DispatchToPropsWithOwnPropsFunction;
import org.stjs.bridge.react.redux.type.MergePropsFunction;
import org.stjs.bridge.react.redux.type.StateToPropsFunction;
import org.stjs.bridge.react.redux.type.StateToPropsWithOwnPropsFunction;
import org.stjs.javascript.annotation.STJSBridge;

@STJSBridge(sources = "webjar:/react-redux.min.js")
public final class ReactRedux {
	public static Class<Component<ProviderProps, State>> Provider;

	/**
	 * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 * The component will not be subscribed to the store
	 *
	 * @param <T> the type of the component that wrapping function will accept
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface> ConnectFunction<T> connect();

	/**
	 * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 * If mapStateToProps is pecified, the {@linkplain Connected} component will subscribe to Redux store updates.
	 * Any time it updates, mapStateToProps will be called. Its result must be a plain object, and it will be merged into the component’s props.
	 * If you omit it, the component will not be subscribed to the Redux store.
	 *
	 * @param mapStateToProps the function to map state retrieved from the store to component's properties
	 * @param <P>             the type of component's props
	 * @param <T>             the type of the component that wrapping function will accept
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsFunction<?, P> mapStateToProps);

	/**
	 * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 * It does not modify the component class passed to it.
	 * Instead, it returns a new, connected component class, for you to use.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param <P>             the props of the wrapped component
	 * @param <T>             the type of the component that wrapping function will accept
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(
			StateToPropsWithOwnPropsFunction<?, P> mapStateToProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps    If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                           will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                           If you omit it, the component will not be subscribed to the Redux store.
	 *                           The second function argument is ownProps and its value will be the props passed to your component,
	 *                           and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param <P>                the props of the wrapped component
	 * @param <T>                the type of the component that wrapping function will accept
	 * @param mapDispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                           (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                           If you omit it, the default implementation just injects dispatch into your component’s props.
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(StateToPropsFunction<?, P> mapStateToProps,
			DispatchToProps<P, ?> mapDispatchToProps);

	/**
	 * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps    If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                           will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                           If you omit it, the component will not be subscribed to the Redux store.
	 *                           The second function argument is ownProps and its value will be the props passed to your component,
	 *                           and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param mapDispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                           (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                           If you omit it, the default implementation just injects dispatch into your component’s props.
	 *                           If ownProps is specified as a second argument, its value will be the props passed to your component,
	 *                           and mapDispatchToProps will be re-invoked whenever the component receives new props.
	 * @param <P>                the props of the wrapped component
	 * @param <T>                the type of the component that wrapping function will accept
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(
			StateToPropsWithOwnPropsFunction<?, P> mapStateToProps, DispatchToProps<P, ?> mapDispatchToProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps    If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                           will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                           If you omit it, the component will not be subscribed to the Redux store.
	 *                           The second function argument is ownProps and its value will be the props passed to your component,
	 *                           and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param mapDispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                           (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                           If you omit it, the default implementation just injects dispatch into your component’s props.
	 *                           If ownProps is specified as a second argument, its value will be the props passed to your component,
	 *                           and mapDispatchToProps will be re-invoked whenever the component receives new props.
	 * @param <P>                the props of the wrapped component
	 * @param <T>                the type of the component that wrapping function will accept
	 * @return wrapper function
	 */
	public static native <T extends ReactClassInterface, P extends Props> ConnectFunction<T> connect(
			StateToPropsWithOwnPropsFunction<?, P> mapStateToProps, DispatchToPropsWithOwnPropsFunction<P, ?> mapDispatchToProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component

	 * @return wrapper function
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsFunction<?, SP> mapStateToProps, DispatchToProps<DP, ?> dispatchToProps, MergePropsFunction<SP, DP, P> mergeProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component
	the props of the wrapped component
	 * @return wrapper function
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsWithOwnPropsFunction<?, SP> mapStateToProps, DispatchToProps<DP, ?> dispatchToProps,
			MergePropsFunction<SP, DP, P> mergeProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 *                        If ownProps is specified as a second argument, its value will be the props passed to your component,
	 *                        and mapDispatchToProps will be re-invoked whenever the component receives new props.
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsFunction<?, SP> mapStateToProps, DispatchToPropsWithOwnPropsFunction<DP, ?> dispatchToProps,
			MergePropsFunction<SP, DP, P> mergeProps);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 * @param options         the options object to modify the default behaviour of resulting {@linkplain Connected} component
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsFunction<?, SP> mapStateToProps, DispatchToProps<DP, ?> dispatchToProps, MergePropsFunction<SP, DP, P> mergeProps,
			Options options);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 * @param options         the options object to modify the default behaviour of resulting {@linkplain Connected} component
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsWithOwnPropsFunction<?, SP> mapStateToProps, DispatchToProps<DP, ?> dispatchToProps,
			MergePropsFunction<SP, DP, P> mergeProps, Options options);

	/**
	 * * Returns the function which will wrap the component which in turn will just inject dispatch property to the passed component after function invocation.
	 *
	 * @param mapStateToProps If specified, the component will subscribe to Redux store updates. Any time it updates, mapStateToProps
	 *                        will be called. Its result must be a plain object*, and it will be merged into the component’s props.
	 *                        If you omit it, the component will not be subscribed to the Redux store.
	 *                        The second function argument is ownProps and its value will be the props passed to your component,
	 *                        and mapStateToProps will be re-invoked whenever the component receives new props.
	 * @param dispatchToProps The function will be given dispatch. It’s up to you to return an object that somehow uses dispatch to bind action creators in your own way.
	 *                        (Tip: you may use the bindActionCreators() helper from Redux.)
	 *                        If you omit it, the default implementation just injects dispatch into your component’s props.
	 *                        If ownProps is specified as a second argument, its value will be the props passed to your component,
	 *                        and mapDispatchToProps will be re-invoked whenever the component receives new props.
	 * @param options         the options object to modify the default behaviour of resulting {@linkplain Connected} component
	 * @param <P>             the props of the wrapped component
	 * @param <SP>            the props type that represents the state of the wrapped component
	 * @param <DP>            the props type that represents the behaviour of the wrapped component
	 * @param <C>             the component type that is wrapped by {@linkplain Connected} component
	 */
	public static native <SP extends Props, DP extends Props, P extends Props, C extends ReactClassInterface<P, ? extends State>> ConnectFunction<C> connect(
			StateToPropsFunction<?, SP> mapStateToProps, DispatchToPropsWithOwnPropsFunction<DP, ?> dispatchToProps,
			MergePropsFunction<SP, DP, P> mergeProps, Options options);

}
