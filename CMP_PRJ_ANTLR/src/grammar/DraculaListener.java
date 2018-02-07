// Generated from /Users/mohammadmahdi/Development/IdeaProjects/CMP_PRJ1/src/grammar/Dracula.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DraculaParser}.
 */
public interface DraculaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DraculaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DraculaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DraculaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#int_s}.
	 * @param ctx the parse tree
	 */
	void enterInt_s(DraculaParser.Int_sContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#int_s}.
	 * @param ctx the parse tree
	 */
	void exitInt_s(DraculaParser.Int_sContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(DraculaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(DraculaParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#double_s}.
	 * @param ctx the parse tree
	 */
	void enterDouble_s(DraculaParser.Double_sContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#double_s}.
	 * @param ctx the parse tree
	 */
	void exitDouble_s(DraculaParser.Double_sContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#deffunc}.
	 * @param ctx the parse tree
	 */
	void enterDeffunc(DraculaParser.DeffuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#deffunc}.
	 * @param ctx the parse tree
	 */
	void exitDeffunc(DraculaParser.DeffuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(DraculaParser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(DraculaParser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(DraculaParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(DraculaParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(DraculaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(DraculaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DraculaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DraculaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#expr_prior3}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prior3(DraculaParser.Expr_prior3Context ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#expr_prior3}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prior3(DraculaParser.Expr_prior3Context ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#expr_prior2}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prior2(DraculaParser.Expr_prior2Context ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#expr_prior2}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prior2(DraculaParser.Expr_prior2Context ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#expr_prior1}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prior1(DraculaParser.Expr_prior1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#expr_prior1}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prior1(DraculaParser.Expr_prior1Context ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(DraculaParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(DraculaParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(DraculaParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(DraculaParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DraculaParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(DraculaParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DraculaParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(DraculaParser.ArgsContext ctx);
}