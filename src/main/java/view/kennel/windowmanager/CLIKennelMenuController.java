package view.kennel.windowmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.windowmanager.CLIUserMenuController;

public class CLIKennelMenuController {
    private static final Logger logger = LogManager.getLogger(CLIKennelMenuController.class.getName());
    public void show() {
        logger.info("Stampa menu kennel");
    }
}
