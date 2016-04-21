package org.stjs.bridge.react.redux.test.component;

import static org.stjs.javascript.JSCollections.*;

import org.stjs.bridge.react.React;
import org.stjs.bridge.react.internal.IsReactClass;
import org.stjs.bridge.react.internal.ReactClass;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.javascript.JSCollections;

@IsReactClass
public class TestButton extends ReactClass<TestButtonProps, State> {

	public static final String TEST_BUTTON_ID = "testButtonId";

	@Override
	public ReactElement<?> render() {
		return React.DOM.button($map("id", TEST_BUTTON_ID, "onClick", this.props.onClickHandler));
	}
}
