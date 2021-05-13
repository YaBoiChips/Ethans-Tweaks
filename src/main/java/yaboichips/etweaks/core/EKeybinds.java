package yaboichips.etweaks.core;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class EKeybinds {
    public static String TWEAKS_CATEGORY = "Ethan's Tweaks";

        public static KeyBinding ROCKET_KEY = new KeyBinding("Rocket Boots", GLFW.GLFW_KEY_R, TWEAKS_CATEGORY);
        public static KeyBinding THROW_SHIELD_KEY = new KeyBinding("Throw Shield", GLFW.GLFW_KEY_G, TWEAKS_CATEGORY);

        public static void register() {
            ClientRegistry.registerKeyBinding(ROCKET_KEY);
            ClientRegistry.registerKeyBinding(THROW_SHIELD_KEY);
        }
    }

