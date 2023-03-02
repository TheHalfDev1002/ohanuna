package chatterbot;

import java.rmi.server.UID;
import java.util.LinkedHashMap;
import java.util.Map;

public final class PandoraBotFactory implements ChatterBotFactory {

	private final String id;

	public PandoraBotFactory(String id) {
		this.id = id;
	}

	@Override
	public ChatterBot create() {
		return new Session();
	}

	private final class Session implements ChatterBot {
		private final Map<String, String> vars;

		public Session() {
			vars = new LinkedHashMap<String, String>();
			vars.put("botid", id);
			vars.put("custid", new UID().toString());
		}

		@Override
		public ChatterBotThought think(ChatterBotThought thought)
				throws Exception {
			vars.put("input", thought.getText());

			String response = Utils.post(
					"http://www.pandorabots.com/pandora/talk-xml", vars);
			return new ChatterBotThought(Utils.xPathSearch(response,
					"//result/that/text()"));
		}

		@Override
		public String think(String text) throws Exception {
			return think(new ChatterBotThought(text)).getText().trim();
		}
	}

}