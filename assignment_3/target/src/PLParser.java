// Generated from java-escape by ANTLR 4.11.1

import backend.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, STRING=27, NUMBER=28, ID=29, INT=30, WS=31, COMMENT=32;
	public static final int
		RULE_program = 0, RULE_ifelse = 1, RULE_declareFunc = 2, RULE_loop = 3, 
		RULE_statement = 4, RULE_assignment = 5, RULE_funCall = 6, RULE_argList = 7, 
		RULE_express = 8, RULE_value = 9, RULE_arithmetic = 10, RULE_comparator = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "ifelse", "declareFunc", "loop", "statement", "assignment", 
			"funCall", "argList", "express", "value", "arithmetic", "comparator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'function'", "','", 
			"'for('", "'in'", "'..'", "';'", "'let'", "'='", "'print('", "'+'", "'++'", 
			"'-'", "'*'", "'/'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "STRING", "NUMBER", "ID", "INT", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public PLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Expr expr;
		public StatementContext s;
		public TerminalNode EOF() { return getToken(PLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> statements = new ArrayList<Expr>();
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				((ProgramContext)_localctx).s = statement();
				 statements.add(((ProgramContext)_localctx).s.expression); 
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 939565702L) != 0 );
			setState(32);
			match(EOF);
			 ((ProgramContext)_localctx).expr =  new Block(statements); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfelseContext extends ParserRuleContext {
		public Expr expression;
		public ExpressContext condition;
		public StatementContext s1;
		public StatementContext s2;
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__0);
			setState(36);
			match(T__1);
			setState(37);
			((IfelseContext)_localctx).condition = express(0);
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);
			 List<Expr> statements1 = new ArrayList<Expr>(); 
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 939565702L) != 0) {
				{
				{
				setState(41);
				((IfelseContext)_localctx).s1 = statement();
				 statements1.add(((IfelseContext)_localctx).s1.expression); 
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(T__4);
			setState(50);
			match(T__5);
			setState(51);
			match(T__3);
			 List<Expr> statements2 = new ArrayList<Expr>(); 
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 939565702L) != 0) {
				{
				{
				setState(53);
				((IfelseContext)_localctx).s2 = statement();
				 statements2.add(((IfelseContext)_localctx).s2.expression); 
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(T__4);
			 ((IfelseContext)_localctx).expression =  new Ifelse(((IfelseContext)_localctx).condition.expression, new Block(statements1), new Block(statements2)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareFuncContext extends ParserRuleContext {
		public Expr expression;
		public Token id;
		public Token str1;
		public Token str2;
		public StatementContext s;
		public List<TerminalNode> ID() { return getTokens(PLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PLParser.ID, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DeclareFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareFunc; }
	}

	public final DeclareFuncContext declareFunc() throws RecognitionException {
		DeclareFuncContext _localctx = new DeclareFuncContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declareFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<String> parameters = new ArrayList<String>();
			setState(65);
			match(T__6);
			setState(66);
			((DeclareFuncContext)_localctx).id = match(ID);
			setState(67);
			match(T__1);
			setState(68);
			((DeclareFuncContext)_localctx).str1 = match(ID);
			 parameters.add((((DeclareFuncContext)_localctx).str1!=null?((DeclareFuncContext)_localctx).str1.getText():null)); 
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(70);
				match(T__7);
				setState(71);
				((DeclareFuncContext)_localctx).str2 = match(ID);
				 parameters.add((((DeclareFuncContext)_localctx).str2!=null?((DeclareFuncContext)_localctx).str2.getText():null)); 
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(T__2);
			setState(79);
			match(T__3);
			 List<Expr> statements = new ArrayList<Expr>(); 
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 939565702L) != 0) {
				{
				{
				setState(81);
				((DeclareFuncContext)_localctx).s = statement();
				 statements.add(((DeclareFuncContext)_localctx).s.expression); 
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(T__4);
			 ((DeclareFuncContext)_localctx).expression =  new Declare((((DeclareFuncContext)_localctx).id!=null?((DeclareFuncContext)_localctx).id.getText():null), parameters , new Block(statements)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public Expr expression;
		public Token id;
		public ExpressContext num1;
		public ExpressContext num2;
		public StatementContext s;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public List<ExpressContext> express() {
			return getRuleContexts(ExpressContext.class);
		}
		public ExpressContext express(int i) {
			return getRuleContext(ExpressContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> statements = new ArrayList<Expr>();
			setState(93);
			match(T__8);
			setState(94);
			((LoopContext)_localctx).id = match(ID);
			setState(95);
			match(T__9);
			setState(96);
			((LoopContext)_localctx).num1 = express(0);
			setState(97);
			match(T__10);
			setState(98);
			((LoopContext)_localctx).num2 = express(0);
			setState(99);
			match(T__2);
			setState(100);
			match(T__3);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 939565702L) != 0) {
				{
				{
				setState(101);
				((LoopContext)_localctx).s = statement();
				 statements.add(((LoopContext)_localctx).s.expression); 
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__4);
			 ((LoopContext)_localctx).expression =  new Loop((((LoopContext)_localctx).id!=null?((LoopContext)_localctx).id.getText():null), ((LoopContext)_localctx).num1.expression, ((LoopContext)_localctx).num2.expression, new Block(statements)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Expr expression;
		public AssignmentContext assign;
		public LoopContext forloop;
		public DeclareFuncContext declare;
		public IfelseContext conditional;
		public ExpressContext e;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public DeclareFuncContext declareFunc() {
			return getRuleContext(DeclareFuncContext.class,0);
		}
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((StatementContext)_localctx).assign = assignment();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(113);
					match(T__11);
					}
				}

				 ((StatementContext)_localctx).expression =  ((StatementContext)_localctx).assign.expression; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((StatementContext)_localctx).forloop = loop();
				 ((StatementContext)_localctx).expression =  ((StatementContext)_localctx).forloop.expression; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				((StatementContext)_localctx).declare = declareFunc();
				 ((StatementContext)_localctx).expression =  ((StatementContext)_localctx).declare.expression; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				((StatementContext)_localctx).conditional = ifelse();
				 ((StatementContext)_localctx).expression =  ((StatementContext)_localctx).conditional.expression; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				((StatementContext)_localctx).e = express(0);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(128);
					match(T__11);
					}
				}

				 ((StatementContext)_localctx).expression =  ((StatementContext)_localctx).e.expression; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public Expr expression;
		public Token id;
		public ExpressContext e;
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(135);
				match(T__12);
				}
			}

			setState(138);
			((AssignmentContext)_localctx).id = match(ID);
			setState(139);
			match(T__13);
			setState(140);
			((AssignmentContext)_localctx).e = express(0);
			 ((AssignmentContext)_localctx).expression =  new Assignment((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null), ((AssignmentContext)_localctx).e.expression); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunCallContext extends ParserRuleContext {
		public Expr expression;
		public ExpressContext e;
		public Token id;
		public ArgListContext arguments;
		public ExpressContext express() {
			return getRuleContext(ExpressContext.class,0);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funCall; }
	}

	public final FunCallContext funCall() throws RecognitionException {
		FunCallContext _localctx = new FunCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funCall);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__14);
				setState(144);
				((FunCallContext)_localctx).e = express(0);
				setState(145);
				match(T__2);
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(146);
					match(T__11);
					}
					break;
				}
				 ((FunCallContext)_localctx).expression =  new Print(((FunCallContext)_localctx).e.expression); 
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				((FunCallContext)_localctx).id = match(ID);
				setState(152);
				match(T__1);
				setState(153);
				((FunCallContext)_localctx).arguments = argList();
				setState(154);
				match(T__2);
				 ((FunCallContext)_localctx).expression =  new Invoke((((FunCallContext)_localctx).id!=null?((FunCallContext)_localctx).id.getText():null), ((FunCallContext)_localctx).arguments.args); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgListContext extends ParserRuleContext {
		public List<Expr> args;
		public ExpressContext e1;
		public ExpressContext e2;
		public List<ExpressContext> express() {
			return getRuleContexts(ExpressContext.class);
		}
		public ExpressContext express(int i) {
			return getRuleContext(ExpressContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> arguments = new ArrayList<Expr>(); 
			setState(160);
			((ArgListContext)_localctx).e1 = express(0);
			 arguments.add(((ArgListContext)_localctx).e1.expression); 
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(162);
				match(T__7);
				setState(163);
				((ArgListContext)_localctx).e2 = express(0);
				 arguments.add(((ArgListContext)_localctx).e2.expression); 
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((ArgListContext)_localctx).args =  arguments; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressContext extends ParserRuleContext {
		public Expr expression;
		public ExpressContext left;
		public ValueContext val;
		public FunCallContext func;
		public ExpressContext e;
		public Token id;
		public ArithmeticContext operator;
		public ExpressContext right;
		public ComparatorContext com;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunCallContext funCall() {
			return getRuleContext(FunCallContext.class,0);
		}
		public List<ExpressContext> express() {
			return getRuleContexts(ExpressContext.class);
		}
		public ExpressContext express(int i) {
			return getRuleContext(ExpressContext.class,i);
		}
		public TerminalNode ID() { return getToken(PLParser.ID, 0); }
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ExpressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_express; }
	}

	public final ExpressContext express() throws RecognitionException {
		return express(0);
	}

	private ExpressContext express(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressContext _localctx = new ExpressContext(_ctx, _parentState);
		ExpressContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_express, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(174);
				((ExpressContext)_localctx).val = value();
				 ((ExpressContext)_localctx).expression =  ((ExpressContext)_localctx).val.v; 
				}
				break;
			case 2:
				{
				setState(177);
				((ExpressContext)_localctx).func = funCall();
				 ((ExpressContext)_localctx).expression =  ((ExpressContext)_localctx).func.expression; 
				}
				break;
			case 3:
				{
				setState(180);
				match(T__1);
				setState(181);
				((ExpressContext)_localctx).e = express(0);
				setState(182);
				match(T__2);
				 ((ExpressContext)_localctx).expression = ((ExpressContext)_localctx).e.expression; 
				}
				break;
			case 4:
				{
				setState(185);
				((ExpressContext)_localctx).id = match(ID);
				 ((ExpressContext)_localctx).expression =  new Deref((((ExpressContext)_localctx).id!=null?((ExpressContext)_localctx).id.getText():null)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_express);
						setState(189);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(190);
						((ExpressContext)_localctx).operator = arithmetic();
						setState(191);
						((ExpressContext)_localctx).right = express(5);
						 ((ExpressContext)_localctx).expression =  new Arithmetics(((ExpressContext)_localctx).operator.op, ((ExpressContext)_localctx).left.expression, ((ExpressContext)_localctx).right.expression); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_express);
						setState(194);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(195);
						((ExpressContext)_localctx).com = comparator();
						setState(196);
						((ExpressContext)_localctx).right = express(4);
						 ((ExpressContext)_localctx).expression =  new Compare(((ExpressContext)_localctx).com.co, ((ExpressContext)_localctx).left.expression, ((ExpressContext)_localctx).right.expression); 
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public Expr v;
		public Token str;
		public Token num;
		public TerminalNode STRING() { return getToken(PLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(PLParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((ValueContext)_localctx).str = match(STRING);
				 ((ValueContext)_localctx).v =  new StringLiteral((((ValueContext)_localctx).str!=null?((ValueContext)_localctx).str.getText():null)); 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((ValueContext)_localctx).num = match(NUMBER);
				 ((ValueContext)_localctx).v =  new IntLiteral((((ValueContext)_localctx).num!=null?((ValueContext)_localctx).num.getText():null)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticContext extends ParserRuleContext {
		public Operator op;
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmetic);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 ((ArithmeticContext)_localctx).op =  Operator.Add; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(T__17);
				 ((ArithmeticContext)_localctx).op =  Operator.Sub; 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(T__18);
				 ((ArithmeticContext)_localctx).op =  Operator.Mul; 
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(T__19);
				 ((ArithmeticContext)_localctx).op =  Operator.Div; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparatorContext extends ParserRuleContext {
		public Comparator co;
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparator);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(T__20);
				 ((ComparatorContext)_localctx).co =  Comparator.LT; 
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__21);
				 ((ComparatorContext)_localctx).co =  Comparator.LE; 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(T__22);
				 ((ComparatorContext)_localctx).co =  Comparator.GT; 
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(T__23);
				 ((ComparatorContext)_localctx).co =  Comparator.GE; 
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(T__24);
				 ((ComparatorContext)_localctx).co =  Comparator.EQ; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				match(T__25);
				 ((ComparatorContext)_localctx).co =  Comparator.NE; 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return express_sempred((ExpressContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean express_sempred(ExpressContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u00eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000\u000b"+
		"\u0000\f\u0000\u001e\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00019\b\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002J\b"+
		"\u0002\n\u0002\f\u0002M\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002U\b\u0002\n\u0002\f\u0002X\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003i\b\u0003\n\u0003"+
		"\f\u0003l\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004s\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0082\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u0086\b\u0004\u0001\u0005\u0003\u0005\u0089"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0094\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u009e\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a7"+
		"\b\u0007\n\u0007\f\u0007\u00aa\t\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00bc\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00c8"+
		"\b\b\n\b\f\b\u00cb\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d1\b"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00db\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00e9\b\u000b\u0001\u000b\u0000\u0001\u0010\f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001"+
		"\u0001\u0000\u0010\u0011\u00fc\u0000\u0018\u0001\u0000\u0000\u0000\u0002"+
		"#\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006\\\u0001"+
		"\u0000\u0000\u0000\b\u0085\u0001\u0000\u0000\u0000\n\u0088\u0001\u0000"+
		"\u0000\u0000\f\u009d\u0001\u0000\u0000\u0000\u000e\u009f\u0001\u0000\u0000"+
		"\u0000\u0010\u00bb\u0001\u0000\u0000\u0000\u0012\u00d0\u0001\u0000\u0000"+
		"\u0000\u0014\u00da\u0001\u0000\u0000\u0000\u0016\u00e8\u0001\u0000\u0000"+
		"\u0000\u0018\u001c\u0006\u0000\uffff\uffff\u0000\u0019\u001a\u0003\b\u0004"+
		"\u0000\u001a\u001b\u0006\u0000\uffff\uffff\u0000\u001b\u001d\u0001\u0000"+
		"\u0000\u0000\u001c\u0019\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 !\u0005\u0000\u0000\u0001"+
		"!\"\u0006\u0000\uffff\uffff\u0000\"\u0001\u0001\u0000\u0000\u0000#$\u0005"+
		"\u0001\u0000\u0000$%\u0005\u0002\u0000\u0000%&\u0003\u0010\b\u0000&\'"+
		"\u0005\u0003\u0000\u0000\'(\u0005\u0004\u0000\u0000(.\u0006\u0001\uffff"+
		"\uffff\u0000)*\u0003\b\u0004\u0000*+\u0006\u0001\uffff\uffff\u0000+-\u0001"+
		"\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000"+
		"\u00000.\u0001\u0000\u0000\u000012\u0005\u0005\u0000\u000023\u0005\u0006"+
		"\u0000\u000034\u0005\u0004\u0000\u00004:\u0006\u0001\uffff\uffff\u0000"+
		"56\u0003\b\u0004\u000067\u0006\u0001\uffff\uffff\u000079\u0001\u0000\u0000"+
		"\u000085\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001"+
		"\u0000\u0000\u0000=>\u0005\u0005\u0000\u0000>?\u0006\u0001\uffff\uffff"+
		"\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0006\u0002\uffff\uffff\u0000"+
		"AB\u0005\u0007\u0000\u0000BC\u0005\u001d\u0000\u0000CD\u0005\u0002\u0000"+
		"\u0000DE\u0005\u001d\u0000\u0000EK\u0006\u0002\uffff\uffff\u0000FG\u0005"+
		"\b\u0000\u0000GH\u0005\u001d\u0000\u0000HJ\u0006\u0002\uffff\uffff\u0000"+
		"IF\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0003\u0000\u0000OP\u0005\u0004\u0000\u0000PV\u0006"+
		"\u0002\uffff\uffff\u0000QR\u0003\b\u0004\u0000RS\u0006\u0002\uffff\uffff"+
		"\u0000SU\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000UX\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\u0005\u0000\u0000"+
		"Z[\u0006\u0002\uffff\uffff\u0000[\u0005\u0001\u0000\u0000\u0000\\]\u0006"+
		"\u0003\uffff\uffff\u0000]^\u0005\t\u0000\u0000^_\u0005\u001d\u0000\u0000"+
		"_`\u0005\n\u0000\u0000`a\u0003\u0010\b\u0000ab\u0005\u000b\u0000\u0000"+
		"bc\u0003\u0010\b\u0000cd\u0005\u0003\u0000\u0000dj\u0005\u0004\u0000\u0000"+
		"ef\u0003\b\u0004\u0000fg\u0006\u0003\uffff\uffff\u0000gi\u0001\u0000\u0000"+
		"\u0000he\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000mn\u0005\u0005\u0000\u0000no\u0006\u0003\uffff\uffff"+
		"\u0000o\u0007\u0001\u0000\u0000\u0000pr\u0003\n\u0005\u0000qs\u0005\f"+
		"\u0000\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000u\u0086\u0001\u0000"+
		"\u0000\u0000vw\u0003\u0006\u0003\u0000wx\u0006\u0004\uffff\uffff\u0000"+
		"x\u0086\u0001\u0000\u0000\u0000yz\u0003\u0004\u0002\u0000z{\u0006\u0004"+
		"\uffff\uffff\u0000{\u0086\u0001\u0000\u0000\u0000|}\u0003\u0002\u0001"+
		"\u0000}~\u0006\u0004\uffff\uffff\u0000~\u0086\u0001\u0000\u0000\u0000"+
		"\u007f\u0081\u0003\u0010\b\u0000\u0080\u0082\u0005\f\u0000\u0000\u0081"+
		"\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0006\u0004\uffff\uffff\u0000"+
		"\u0084\u0086\u0001\u0000\u0000\u0000\u0085p\u0001\u0000\u0000\u0000\u0085"+
		"v\u0001\u0000\u0000\u0000\u0085y\u0001\u0000\u0000\u0000\u0085|\u0001"+
		"\u0000\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000\u0086\t\u0001\u0000"+
		"\u0000\u0000\u0087\u0089\u0005\r\u0000\u0000\u0088\u0087\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005\u001d\u0000\u0000\u008b\u008c\u0005\u000e\u0000"+
		"\u0000\u008c\u008d\u0003\u0010\b\u0000\u008d\u008e\u0006\u0005\uffff\uffff"+
		"\u0000\u008e\u000b\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u000f\u0000"+
		"\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0093\u0005\u0003\u0000\u0000"+
		"\u0092\u0094\u0005\f\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0006\u0006\uffff\uffff\u0000\u0096\u009e\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0005\u001d\u0000\u0000\u0098\u0099\u0005\u0002\u0000\u0000"+
		"\u0099\u009a\u0003\u000e\u0007\u0000\u009a\u009b\u0005\u0003\u0000\u0000"+
		"\u009b\u009c\u0006\u0006\uffff\uffff\u0000\u009c\u009e\u0001\u0000\u0000"+
		"\u0000\u009d\u008f\u0001\u0000\u0000\u0000\u009d\u0097\u0001\u0000\u0000"+
		"\u0000\u009e\r\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u0007\uffff\uffff"+
		"\u0000\u00a0\u00a1\u0003\u0010\b\u0000\u00a1\u00a8\u0006\u0007\uffff\uffff"+
		"\u0000\u00a2\u00a3\u0005\b\u0000\u0000\u00a3\u00a4\u0003\u0010\b\u0000"+
		"\u00a4\u00a5\u0006\u0007\uffff\uffff\u0000\u00a5\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0006\u0007\uffff\uffff\u0000\u00ac\u000f\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0006\b\uffff\uffff\u0000\u00ae\u00af\u0003\u0012"+
		"\t\u0000\u00af\u00b0\u0006\b\uffff\uffff\u0000\u00b0\u00bc\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0003\f\u0006\u0000\u00b2\u00b3\u0006\b\uffff"+
		"\uffff\u0000\u00b3\u00bc\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u0002"+
		"\u0000\u0000\u00b5\u00b6\u0003\u0010\b\u0000\u00b6\u00b7\u0005\u0003\u0000"+
		"\u0000\u00b7\u00b8\u0006\b\uffff\uffff\u0000\u00b8\u00bc\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0005\u001d\u0000\u0000\u00ba\u00bc\u0006\b\uffff\uffff"+
		"\u0000\u00bb\u00ad\u0001\u0000\u0000\u0000\u00bb\u00b1\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b4\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bc\u00c9\u0001\u0000\u0000\u0000\u00bd\u00be\n\u0004\u0000\u0000"+
		"\u00be\u00bf\u0003\u0014\n\u0000\u00bf\u00c0\u0003\u0010\b\u0005\u00c0"+
		"\u00c1\u0006\b\uffff\uffff\u0000\u00c1\u00c8\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\n\u0003\u0000\u0000\u00c3\u00c4\u0003\u0016\u000b\u0000\u00c4\u00c5"+
		"\u0003\u0010\b\u0004\u00c5\u00c6\u0006\b\uffff\uffff\u0000\u00c6\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c7\u00bd\u0001\u0000\u0000\u0000\u00c7\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u0011"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0005\u001b\u0000\u0000\u00cd\u00d1\u0006\t\uffff\uffff\u0000\u00ce\u00cf"+
		"\u0005\u001c\u0000\u0000\u00cf\u00d1\u0006\t\uffff\uffff\u0000\u00d0\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u0013"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0007\u0000\u0000\u0000\u00d3\u00db"+
		"\u0006\n\uffff\uffff\u0000\u00d4\u00d5\u0005\u0012\u0000\u0000\u00d5\u00db"+
		"\u0006\n\uffff\uffff\u0000\u00d6\u00d7\u0005\u0013\u0000\u0000\u00d7\u00db"+
		"\u0006\n\uffff\uffff\u0000\u00d8\u00d9\u0005\u0014\u0000\u0000\u00d9\u00db"+
		"\u0006\n\uffff\uffff\u0000\u00da\u00d2\u0001\u0000\u0000\u0000\u00da\u00d4"+
		"\u0001\u0000\u0000\u0000\u00da\u00d6\u0001\u0000\u0000\u0000\u00da\u00d8"+
		"\u0001\u0000\u0000\u0000\u00db\u0015\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0005\u0015\u0000\u0000\u00dd\u00e9\u0006\u000b\uffff\uffff\u0000\u00de"+
		"\u00df\u0005\u0016\u0000\u0000\u00df\u00e9\u0006\u000b\uffff\uffff\u0000"+
		"\u00e0\u00e1\u0005\u0017\u0000\u0000\u00e1\u00e9\u0006\u000b\uffff\uffff"+
		"\u0000\u00e2\u00e3\u0005\u0018\u0000\u0000\u00e3\u00e9\u0006\u000b\uffff"+
		"\uffff\u0000\u00e4\u00e5\u0005\u0019\u0000\u0000\u00e5\u00e9\u0006\u000b"+
		"\uffff\uffff\u0000\u00e6\u00e7\u0005\u001a\u0000\u0000\u00e7\u00e9\u0006"+
		"\u000b\uffff\uffff\u0000\u00e8\u00dc\u0001\u0000\u0000\u0000\u00e8\u00de"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e0\u0001\u0000\u0000\u0000\u00e8\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000\u0000\u00e8\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e9\u0017\u0001\u0000\u0000\u0000\u0013\u001e"+
		".:KVjr\u0081\u0085\u0088\u0093\u009d\u00a8\u00bb\u00c7\u00c9\u00d0\u00da"+
		"\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}