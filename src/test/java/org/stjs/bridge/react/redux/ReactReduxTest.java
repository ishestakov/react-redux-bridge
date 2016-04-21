package org.stjs.bridge.react.redux;

import static org.stjs.javascript.JSCollections.$array;
import static org.stjs.javascript.JSCollections.$map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.React;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.bridge.react.redux.test.component.TestButton;
import org.stjs.bridge.react.redux.test.component.TestButtonProps;
import org.stjs.bridge.react.redux.test.component.TestComponent;
import org.stjs.bridge.react.redux.test.component.TestProps;
import org.stjs.bridge.react.redux.type.ConnectFunction;
import org.stjs.bridge.react.redux.type.DispatchToProps;
import org.stjs.bridge.react.redux.type.StateToPropsFunction;
import org.stjs.bridge.redux.Redux;
import org.stjs.bridge.redux.api.Action;
import org.stjs.bridge.redux.api.Reducer;
import org.stjs.bridge.redux.api.Store;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Callback0;
import org.stjs.testing.annotation.HTMLFixture;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@HTMLFixture("<div id='content'></div>")
public class ReactReduxTest {

	public static final String TEST_TEXT_ID = "testText";
	public static final String TEST_PAYLOAD = "42";
	public static final String TEST_ACTION_TYPE = "TEST";
	public static final Reducer<Object, Object, Object> TEST_REDUCER = (state, action) -> {
		switch (action.type) {
			case TEST_ACTION_TYPE:
				return $map("test", action.payload);
			default:
				return state;
		}
	};
	public static final StateToPropsFunction<Map<String, String>, TestProps> MAP_STATE_TO_PROPS = (object) -> new TestProps() {
		{
			this.prop = object.$get("test");
		}
	};
	private Element content;
	private Store globalStore;

	@Before
	public void setUp() {
		this.content = Global.window.document.getElementById("content");
		this.globalStore = Redux.createStore(TEST_REDUCER, new java.lang.Object());
	}

	@Test
	public void testProvider() {
		React.render(React.createElement(ReactRedux.Provider, new ProviderProps() {
			{
				this.store = globalStore;
			}
		}, React.DOM.div()), content);
	}

	@Test
	public void testConnect() {

		Element content = Global.window.document.getElementById("content");

		React.render(createProvider(globalStore, $array(connectTestComponent(MAP_STATE_TO_PROPS))), content);
		globalStore.dispatch(createTestAction());
		String nodeValue = Global.window.document.getElementById(TEST_TEXT_ID).innerHTML.trim();
		Assert.assertEquals(TEST_PAYLOAD, nodeValue);
	}

	@Test
	public void testMapDispatch() {
		ReactReduxTest self = this;
		ReactElement<Connected> connectTestComponent = connectTestComponent(MAP_STATE_TO_PROPS);
		DispatchToProps<TestButtonProps, Callback0> dispatchToProps = (dispatch) -> new TestButtonProps() {
			{
				this.onClickHandler = () -> dispatch.$invoke(self.createTestAction());
			}
		};

		ConnectFunction<TestButton> connect =
				ReactRedux.<TestButton, TestButtonProps> connect((StateToPropsFunction<Object, TestButtonProps>) null, dispatchToProps);
		ReactElement<Connected> connectedButton = React.createElement(connect.$invoke(TestButton.class), null);
		React.render(createProvider(globalStore, JSCollections.<ReactElement<?>> $array(connectTestComponent, connectedButton)), content);

		JSObjectAdapter.$js("var event = new MouseEvent('click', {'view':window, 'bubbles': true, 'cancelable':true});"
				+ " document.getElementById('testButtonId').dispatchEvent(event);");
		String nodeValue = Global.window.document.getElementById(TEST_TEXT_ID).innerHTML.trim();
		Assert.assertEquals(TEST_PAYLOAD, nodeValue);

	}

	private Action<String, Void> createTestAction() {
		return new Action<String, Void>() {
			{
				this.type = TEST_ACTION_TYPE;
				this.payload = TEST_PAYLOAD;
			}
		};
	}

	private ReactElement<Component<ProviderProps, State>> createProvider(final Store newStore, Array<ReactElement<?>> children) {
		ReactElement<?> child = React.DOM.div(null, children);
		return React.createElement(ReactRedux.Provider, new ProviderProps() {
			{
				this.store = newStore;
			}
		}, child);
	}

	private ReactElement<Connected> connectTestComponent(StateToPropsFunction<Map<String, String>, TestProps> mapStateToProps) {
		return React.createElement(ReactRedux.<TestComponent, TestProps> connect(mapStateToProps).$invoke(TestComponent.class), null);
	}

}