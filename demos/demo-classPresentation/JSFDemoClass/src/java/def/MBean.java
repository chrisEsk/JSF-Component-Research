package def;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBean")
@SessionScoped
public class MBean implements Serializable {

    Integer output;

    public MBean() {
        this.setOutput(0);
    }

    public void sum() {
        this.output++;
        this.setOutput(output);
    }

    public void res() {
        this.output--;
        this.setOutput(output);
    }

    /**
     * @return the output
     */
    public Integer getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

}
