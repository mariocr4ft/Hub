package club.winterlegends.hubcore.config.managers;

import club.winterlegends.hubcore.util.enums.GeneralSetting;

public class GeneralSettings {

    public GeneralSettings(Boolean... settings) {
        for (int id = 0; id < (settings.length - 1); id++) {
            GeneralSetting setting = GeneralSetting.fromID(id);
            setting.setEnabled(settings[id]);
        }
    }
}
