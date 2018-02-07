// Generated from /Users/mohammadmahdi/Development/IdeaProjects/CMP_PRJ1/src/grammar/Dracula.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DraculaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WHITESPACE=8, 
		NAME=9, INT=10, DOUBLE=11, TYPE=12, MINUS=13, PLUS=14, MULTIPLY=15, DIVIDE=16, 
		ONE=17, GIVE=18, MKDATE=19, FUNCOP=20;
	public static final int
		RULE_program = 0, RULE_int_s = 1, RULE_name = 2, RULE_double_s = 3, RULE_deffunc = 4, 
		RULE_defvar = 5, RULE_def = 6, RULE_assign = 7, RULE_expr = 8, RULE_expr_prior3 = 9, 
		RULE_expr_prior2 = 10, RULE_expr_prior1 = 11, RULE_funccall = 12, RULE_arg = 13, 
		RULE_args = 14;
	public static final String[] ruleNames = {
		"program", "int_s", "name", "double_s", "deffunc", "defvar", "def", "assign", 
		"expr", "expr_prior3", "expr_prior2", "expr_prior1", "funccall", "arg", 
		"args"
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

	@Override
	public String getGrammarFileName() { return "Dracula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DraculaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<FunccallContext> funccall() {
			return getRuleContexts(FunccallContext.class);
		}
		public FunccallContext funccall(int i) {
			return getRuleContext(FunccallContext.class,i);
		}
		public List<DefContext> def() {
			return getRuleContexts(DefContext.class);
		}
		public DefContext def(int i) {
			return getRuleContext(DefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << NAME) | (1L << ONE) | (1L << GIVE) | (1L << MKDATE) | (1L << FUNCOP))) != 0)) {
				{
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					assign();
					}
					break;
				case 2:
					{
					setState(31);
					funccall();
					}
					break;
				case 3:
					{
					setState(32);
					def();
					}
					break;
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_sContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DraculaParser.INT, 0); }
		public Int_sContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterInt_s(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitInt_s(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitInt_s(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_sContext int_s() throws RecognitionException {
		Int_sContext _localctx = new Int_sContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_int_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(DraculaParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Double_sContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(DraculaParser.DOUBLE, 0); }
		public Double_sContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterDouble_s(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitDouble_s(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitDouble_s(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_sContext double_s() throws RecognitionException {
		Double_sContext _localctx = new Double_sContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_double_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(DOUBLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeffuncContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(DraculaParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(DraculaParser.TYPE, i);
		}
		public DeffuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deffunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterDeffunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitDeffunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitDeffunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeffuncContext deffunc() throws RecognitionException {
		DeffuncContext _localctx = new DeffuncContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_deffunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(45);
				match(TYPE);
				}
				break;
			case 2:
				{
				setState(46);
				match(TYPE);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(47);
					match(T__1);
					setState(48);
					match(TYPE);
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(56);
			match(T__2);
			setState(57);
			match(T__3);
			setState(58);
			match(TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefvarContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(DraculaParser.TYPE, 0); }
		public DefvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterDefvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitDefvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitDefvar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefvarContext defvar() throws RecognitionException {
		DefvarContext _localctx = new DefvarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(DraculaParser.NAME, 0); }
		public DefvarContext defvar() {
			return getRuleContext(DefvarContext.class,0);
		}
		public DeffuncContext deffunc() {
			return getRuleContext(DeffuncContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_def);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(NAME);
				setState(63);
				match(T__4);
				setState(66);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(64);
					defvar();
					}
					break;
				case T__0:
					{
					setState(65);
					deffunc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__5);
				setState(69);
				deffunc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(DraculaParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(NAME);
			setState(73);
			match(T__6);
			setState(74);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expr_prior3Context expr_prior3() {
			return getRuleContext(Expr_prior3Context.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			expr_prior3();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_prior3Context extends ParserRuleContext {
		public Expr_prior2Context expr_prior2() {
			return getRuleContext(Expr_prior2Context.class,0);
		}
		public List<Expr_prior3Context> expr_prior3() {
			return getRuleContexts(Expr_prior3Context.class);
		}
		public Expr_prior3Context expr_prior3(int i) {
			return getRuleContext(Expr_prior3Context.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(DraculaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(DraculaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(DraculaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(DraculaParser.MINUS, i);
		}
		public Expr_prior3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prior3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterExpr_prior3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitExpr_prior3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitExpr_prior3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_prior3Context expr_prior3() throws RecognitionException {
		Expr_prior3Context _localctx = new Expr_prior3Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr_prior3);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			expr_prior2();
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(80);
					expr_prior3();
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_prior2Context extends ParserRuleContext {
		public Expr_prior1Context expr_prior1() {
			return getRuleContext(Expr_prior1Context.class,0);
		}
		public List<Expr_prior2Context> expr_prior2() {
			return getRuleContexts(Expr_prior2Context.class);
		}
		public Expr_prior2Context expr_prior2(int i) {
			return getRuleContext(Expr_prior2Context.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(DraculaParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(DraculaParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(DraculaParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(DraculaParser.DIVIDE, i);
		}
		public Expr_prior2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prior2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterExpr_prior2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitExpr_prior2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitExpr_prior2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_prior2Context expr_prior2() throws RecognitionException {
		Expr_prior2Context _localctx = new Expr_prior2Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr_prior2);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			expr_prior1();
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					_la = _input.LA(1);
					if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(88);
					expr_prior2();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_prior1Context extends ParserRuleContext {
		public Int_sContext int_s() {
			return getRuleContext(Int_sContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Double_sContext double_s() {
			return getRuleContext(Double_sContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public Expr_prior1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prior1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterExpr_prior1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitExpr_prior1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitExpr_prior1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_prior1Context expr_prior1() throws RecognitionException {
		Expr_prior1Context _localctx = new Expr_prior1Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr_prior1);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				int_s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				double_s();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(T__0);
				setState(98);
				expr();
				setState(99);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				funccall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunccallContext extends ParserRuleContext {
		public TerminalNode ONE() { return getToken(DraculaParser.ONE, 0); }
		public TerminalNode GIVE() { return getToken(DraculaParser.GIVE, 0); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public TerminalNode NAME() { return getToken(DraculaParser.NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode MKDATE() { return getToken(DraculaParser.MKDATE, 0); }
		public TerminalNode FUNCOP() { return getToken(DraculaParser.FUNCOP, 0); }
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitFunccall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funccall);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ONE:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(ONE);
				}
				break;
			case GIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(GIVE);
				setState(106);
				match(T__0);
				setState(107);
				arg();
				setState(108);
				match(T__2);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(NAME);
				setState(111);
				match(T__0);
				setState(112);
				args();
				setState(113);
				match(T__2);
				}
				break;
			case MKDATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				match(MKDATE);
				setState(116);
				match(T__0);
				setState(117);
				arg();
				setState(118);
				match(T__1);
				setState(119);
				arg();
				setState(120);
				match(T__2);
				}
				break;
			case FUNCOP:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				match(FUNCOP);
				setState(123);
				match(T__0);
				setState(124);
				arg();
				setState(125);
				match(T__1);
				setState(126);
				arg();
				setState(127);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DraculaListener ) ((DraculaListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DraculaVisitor ) return ((DraculaVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			arg();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(134);
				match(T__1);
				setState(135);
				arg();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6\64"+
		"\n\6\f\6\16\6\67\13\6\5\69\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\5\bE\n\b\3\b\3\b\5\bI\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13"+
		"T\n\13\f\13\16\13W\13\13\3\f\3\f\3\f\7\f\\\n\f\f\f\16\f_\13\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\ri\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0084\n\16\3\17\3\17\3\20\3\20\3\20\7\20\u008b"+
		"\n\20\f\20\16\20\u008e\13\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36\2\4\3\2\17\20\3\2\21\22\2\u0092\2%\3\2\2\2\4(\3\2\2\2\6*\3\2"+
		"\2\2\b,\3\2\2\2\n.\3\2\2\2\f>\3\2\2\2\16H\3\2\2\2\20J\3\2\2\2\22N\3\2"+
		"\2\2\24P\3\2\2\2\26X\3\2\2\2\30h\3\2\2\2\32\u0083\3\2\2\2\34\u0085\3\2"+
		"\2\2\36\u0087\3\2\2\2 $\5\20\t\2!$\5\32\16\2\"$\5\16\b\2# \3\2\2\2#!\3"+
		"\2\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2"+
		"()\7\f\2\2)\5\3\2\2\2*+\7\13\2\2+\7\3\2\2\2,-\7\r\2\2-\t\3\2\2\2.8\7\3"+
		"\2\2/9\7\16\2\2\60\65\7\16\2\2\61\62\7\4\2\2\62\64\7\16\2\2\63\61\3\2"+
		"\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\28/\3\2\2\28\60\3\2\2\29:\3\2\2\2:;\7\5\2\2;<\7\6\2\2<=\7\16\2\2=\13"+
		"\3\2\2\2>?\7\16\2\2?\r\3\2\2\2@A\7\13\2\2AD\7\7\2\2BE\5\f\7\2CE\5\n\6"+
		"\2DB\3\2\2\2DC\3\2\2\2EI\3\2\2\2FG\7\b\2\2GI\5\n\6\2H@\3\2\2\2HF\3\2\2"+
		"\2I\17\3\2\2\2JK\7\13\2\2KL\7\t\2\2LM\5\22\n\2M\21\3\2\2\2NO\5\24\13\2"+
		"O\23\3\2\2\2PU\5\26\f\2QR\t\2\2\2RT\5\24\13\2SQ\3\2\2\2TW\3\2\2\2US\3"+
		"\2\2\2UV\3\2\2\2V\25\3\2\2\2WU\3\2\2\2X]\5\30\r\2YZ\t\3\2\2Z\\\5\26\f"+
		"\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\27\3\2\2\2_]\3\2\2\2`i\5"+
		"\4\3\2ai\5\6\4\2bi\5\b\5\2cd\7\3\2\2de\5\22\n\2ef\7\5\2\2fi\3\2\2\2gi"+
		"\5\32\16\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2\2hc\3\2\2\2hg\3\2\2\2i\31\3\2\2"+
		"\2j\u0084\7\23\2\2kl\7\24\2\2lm\7\3\2\2mn\5\34\17\2no\7\5\2\2o\u0084\3"+
		"\2\2\2pq\7\13\2\2qr\7\3\2\2rs\5\36\20\2st\7\5\2\2t\u0084\3\2\2\2uv\7\25"+
		"\2\2vw\7\3\2\2wx\5\34\17\2xy\7\4\2\2yz\5\34\17\2z{\7\5\2\2{\u0084\3\2"+
		"\2\2|}\7\26\2\2}~\7\3\2\2~\177\5\34\17\2\177\u0080\7\4\2\2\u0080\u0081"+
		"\5\34\17\2\u0081\u0082\7\5\2\2\u0082\u0084\3\2\2\2\u0083j\3\2\2\2\u0083"+
		"k\3\2\2\2\u0083p\3\2\2\2\u0083u\3\2\2\2\u0083|\3\2\2\2\u0084\33\3\2\2"+
		"\2\u0085\u0086\5\22\n\2\u0086\35\3\2\2\2\u0087\u008c\5\34\17\2\u0088\u0089"+
		"\7\4\2\2\u0089\u008b\5\34\17\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\37\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\r#%\658DHU]h\u0083\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}