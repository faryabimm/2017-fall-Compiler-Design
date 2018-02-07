// Generated from /Users/mohammadmahdi/Development/IdeaProjects/CMP_PRJ1/src/grammar/Dracula.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DraculaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DraculaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DraculaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DraculaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#int_s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_s(DraculaParser.Int_sContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(DraculaParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#double_s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble_s(DraculaParser.Double_sContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#deffunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeffunc(DraculaParser.DeffuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(DraculaParser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(DraculaParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(DraculaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DraculaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#expr_prior3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prior3(DraculaParser.Expr_prior3Context ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#expr_prior2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prior2(DraculaParser.Expr_prior2Context ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#expr_prior1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_prior1(DraculaParser.Expr_prior1Context ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#funccall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(DraculaParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(DraculaParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DraculaParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(DraculaParser.ArgsContext ctx);
}