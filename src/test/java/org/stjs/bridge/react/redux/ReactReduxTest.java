package org.stjs.bridge.react.redux;

import static org.stjs.javascript.JSCollections.$map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.bridge.react.Component;
import org.stjs.bridge.react.React;
import org.stjs.bridge.react.internal.Props;
import org.stjs.bridge.react.internal.ReactElement;
import org.stjs.bridge.react.internal.State;
import org.stjs.bridge.react.redux.type.StateToPropsFunction;
import org.stjs.bridge.redux.Redux;
import org.stjs.bridge.redux.api.Action;
import org.stjs.bridge.redux.api.Store;
import org.stjs.javascript.Global;
import org.stjs.javascript.Map;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.functions.Function1;
import org.stjs.testing.annotation.HTMLFixture;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"react.js", "/react-redux.min.js"})
@HTMLFixture("<div id='content'></div>")
public class ReactReduxTest {

	public static final String TEST_TEXT_ID = "testText";

	@Test
	public void testProvider() {
		final Store createdStore = Redux.createStore((action, state) -> {
			return state;
		}, new Object());
		Element content = Global.window.document.getElementById("content");
		React.render(React.createElement(ReactRedux.Provider, new ProviderProps() {
			{
				this.store = createdStore;
			}
		}, React.DOM.div()), content);
	}

	@Test
	public void testConnect() {
		final Store newStore = Redux.createStore((state, action) -> {
			switch (action.type) {
				case "TEST":
					return $map("test", action.payload);
				default:
					return state;
			}
		}, new java.lang.Object());

		Element content = Global.window.document.getElementById("content");
		StateToPropsFunction<Map<String, String>, TestProps> mapStateToProps = (object) -> new TestProps() {
			{
				this.prop = object.$get("test");
			}
		};

		React.render(React.createElement(ReactRedux.Provider, new ProviderProps() {
					{
						this.store = newStore;
					}
				}, React.createElement(ReactRedux.<TestComponent, TestProps> connect(mapStateToProps).$invoke(TestComponent.class), new Props())),
				content);
		newStore.dispatch(new Action<String, Void>() {
			{
				this.type = "TEST";
				this.payload = "42";
			}
		});
		String nodeValue = Global.window.document.getElementById(TEST_TEXT_ID).innerHTML.trim();
		Assert.assertEquals("42", nodeValue);
	}

	public static class TestProps extends Props {
		public String prop;
	}

	public static class TestComponent extends Component<TestProps, State> {

		public TestComponent(TestProps props) {
			super(props);
		}

		@Override
		public ReactElement<?> render() {
			return React.DOM.span($map("id", TEST_TEXT_ID), this.props.prop);
		}
	}

}