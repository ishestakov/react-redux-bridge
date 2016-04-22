package org.stjs.bridge.react.redux;

import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.annotation.SyntheticType;

@STJSBridge
@SyntheticType
/**
 * An options object to customize the behaviour of the {@linkplain Connected} component.
 */
public final class Options {
	/**
	 * If true, implements shouldComponentUpdate and shallowly compares the result of mergeProps, preventing unnecessary updates,
	 * assuming that the component is a “pure” component and does not rely on any input or state other than its props and the selected
	 * Redux store’s state.
	 * <br />
	 * Defaults to true.
	 */
	public Boolean pure;

	/**
	 * If true, stores a ref to the wrapped component instance and makes it available via {@linkplain Connected#getWrappedInstance()} method.
	 * <br />
	 * Defaults to false.
	 */
	public Boolean withRef;
}
