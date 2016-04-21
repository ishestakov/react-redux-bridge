package org.stjs.bridge.react.redux.test.component;

import static org.stjs.javascript.JSCollections.$map;

import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.React;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.bridge.react.redux.ReactReduxTest;
import org.stjs.javascript.annotation.SyntheticType;

@SyntheticType
public class TestComponent extends Component<TestProps, State> {

	public TestComponent(TestProps props) {
		super(props);
	}

	@Override
	public ReactElement<?> render() {
		return React.DOM.span($map("id", ReactReduxTest.TEST_TEXT_ID), this.props.prop);
	}
}
