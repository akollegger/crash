import org.crsh.cmdline.annotations.Command
import org.crsh.cmdline.annotations.Usage
import org.crsh.command.PipeCommand;
import javax.jcr.Node;

public class consume extends org.crsh.command.CRaSHCommand {
  @Command
  @Usage("collects and log a set of nodes")
  public PipeCommand<Node, Object> main() {
    return new PipeCommand<Node, Object>() {
      @Override
      void provide(Node element) {
        out.println(element.path);
      }
    }
  }
}