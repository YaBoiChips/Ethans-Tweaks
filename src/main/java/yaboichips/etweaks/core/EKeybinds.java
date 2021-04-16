package yaboichips.etweaks.core;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class EKeybinds {
        public static KeyBinding ROCKET_KEY = new KeyBinding("Rocket Boots", GLFW.GLFW_KEY_R, "Ethans Tweaks");

        public static void register() {
            ClientRegistry.registerKeyBinding(ROCKET_KEY);
        }
    }

