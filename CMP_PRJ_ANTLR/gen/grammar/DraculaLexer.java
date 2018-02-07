// Generated from /Users/mohammadmahdi/Development/IdeaProjects/CMP_PRJ1/src/grammar/Dracula.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DraculaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WHITESPACE=8, 
		NAME=9, INT=10, DOUBLE=11, TYPE=12, MINUS=13, PLUS=14, MULTIPLY=15, DIVIDE=16, 
		ONE=17, GIVE=18, MKDATE=19, FUNCOP=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "WHITESPACE", 
		"NAME", "INT", "DOUBLE", "TYPE", "MINUS", "PLUS", "MULTIPLY", "DIVIDE", 
		"ONE", "GIVE", "MKDATE", "FUNCOP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'->'", "'::'", "'TimeFunc'", "'='", null, 
		null, null, null, null, "'-'", "'+'", "'*'", "'/'", null, "'give'", "'Mkdate'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "WHITESPACE", "NAME", 
		"INT", "DOUBLE", "TYPE", "MINUS", "PLUS", "MULTIPLY", "DIVIDE", "ONE", 
		"GIVE", "MKDATE", "FUNCOP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DraculaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dracula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00c1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tD\n"+
		"\t\r\t\16\tE\3\t\3\t\3\n\6\nK\n\n\r\n\16\nL\3\n\7\nP\n\n\f\n\16\nS\13"+
		"\n\3\13\6\13V\n\13\r\13\16\13W\3\f\6\f[\n\f\r\f\16\f\\\3\f\3\f\7\fa\n"+
		"\f\f\f\16\fd\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r{\n\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\7\22\u008a\n\22\f\22\16\22\u008d\13"+
		"\22\3\22\3\22\7\22\u0091\n\22\f\22\16\22\u0094\13\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00c0\n\25"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\6\5\2\13\f\17\17\"\"\3\2c|\4\2\62"+
		";c|\3\2\62;\2\u00d0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2"+
		"\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\64\3\2\2\2\r\67\3\2\2\2\17@\3\2"+
		"\2\2\21C\3\2\2\2\23J\3\2\2\2\25U\3\2\2\2\27Z\3\2\2\2\31z\3\2\2\2\33|\3"+
		"\2\2\2\35~\3\2\2\2\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0084\3\2\2\2%\u0097"+
		"\3\2\2\2\'\u009c\3\2\2\2)\u00bf\3\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7.\2\2."+
		"\6\3\2\2\2/\60\7+\2\2\60\b\3\2\2\2\61\62\7/\2\2\62\63\7@\2\2\63\n\3\2"+
		"\2\2\64\65\7<\2\2\65\66\7<\2\2\66\f\3\2\2\2\678\7V\2\289\7k\2\29:\7o\2"+
		"\2:;\7g\2\2;<\7H\2\2<=\7w\2\2=>\7p\2\2>?\7e\2\2?\16\3\2\2\2@A\7?\2\2A"+
		"\20\3\2\2\2BD\t\2\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2"+
		"\2GH\b\t\2\2H\22\3\2\2\2IK\t\3\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2"+
		"\2\2MQ\3\2\2\2NP\t\4\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\24\3"+
		"\2\2\2SQ\3\2\2\2TV\t\5\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\26"+
		"\3\2\2\2Y[\t\5\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2"+
		"\2^b\7\60\2\2_a\t\5\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\30\3"+
		"\2\2\2db\3\2\2\2ef\7K\2\2fg\7p\2\2g{\7v\2\2hi\7F\2\2ij\7q\2\2jk\7w\2\2"+
		"kl\7d\2\2lm\7n\2\2m{\7g\2\2no\7F\2\2op\7c\2\2pq\7v\2\2q{\7g\2\2rs\7E\2"+
		"\2st\7q\2\2tu\7p\2\2uv\7v\2\2vw\7t\2\2wx\7c\2\2xy\7e\2\2y{\7v\2\2ze\3"+
		"\2\2\2zh\3\2\2\2zn\3\2\2\2zr\3\2\2\2{\32\3\2\2\2|}\7/\2\2}\34\3\2\2\2"+
		"~\177\7-\2\2\177\36\3\2\2\2\u0080\u0081\7,\2\2\u0081 \3\2\2\2\u0082\u0083"+
		"\7\61\2\2\u0083\"\3\2\2\2\u0084\u0085\7q\2\2\u0085\u0086\7p\2\2\u0086"+
		"\u0087\7g\2\2\u0087\u008b\3\2\2\2\u0088\u008a\5\21\t\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\7*\2\2\u008f\u0091\5\21"+
		"\t\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7+"+
		"\2\2\u0096$\3\2\2\2\u0097\u0098\7i\2\2\u0098\u0099\7k\2\2\u0099\u009a"+
		"\7x\2\2\u009a\u009b\7g\2\2\u009b&\3\2\2\2\u009c\u009d\7O\2\2\u009d\u009e"+
		"\7m\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7v\2\2\u00a1"+
		"\u00a2\7g\2\2\u00a2(\3\2\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7p\2\2\u00a5"+
		"\u00c0\7f\2\2\u00a6\u00a7\7q\2\2\u00a7\u00c0\7t\2\2\u00a8\u00a9\7v\2\2"+
		"\u00a9\u00aa\7j\2\2\u00aa\u00ab\7g\2\2\u00ab\u00c0\7p\2\2\u00ac\u00ad"+
		"\7u\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2\u00b0"+
		"\u00b1\7g\2\2\u00b1\u00c0\7Z\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7e\2\2"+
		"\u00b4\u00b5\7c\2\2\u00b5\u00b6\7n\2\2\u00b6\u00c0\7g\2\2\u00b7\u00b8"+
		"\7v\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7p\2\2\u00bb"+
		"\u00bc\7e\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7v\2\2\u00be\u00c0\7g\2\2"+
		"\u00bf\u00a3\3\2\2\2\u00bf\u00a6\3\2\2\2\u00bf\u00a8\3\2\2\2\u00bf\u00ac"+
		"\3\2\2\2\u00bf\u00b2\3\2\2\2\u00bf\u00b7\3\2\2\2\u00c0*\3\2\2\2\r\2EL"+
		"QW\\bz\u008b\u0092\u00bf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}