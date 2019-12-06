package com.wx.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class SpeachUtil {
//	message 是需要转换的文本信息，volume是声音大小，rate是读取速度。
public static void speakMessage(String message, int volume, int rate) {

		ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
		Dispatch sapo = sap.getObject();
		try {

			sap.setProperty("Volume", new Variant(volume));
			sap.setProperty("Rate", new Variant(rate));
			Dispatch.call(sapo, "Speak", new Variant(message));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sapo.safeRelease();
			sap.safeRelease();
		}
	}


//	public static void main(String[] args) {
//		SpeachUtil s = new SpeachUtil();
//		s.speakMessage("222", 80, 2);
//	}
}
