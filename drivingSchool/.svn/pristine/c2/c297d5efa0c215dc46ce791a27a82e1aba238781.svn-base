package com.HuiShengTec.app.publicAction;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code11Encoder;
import org.jbarcode.paint.TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HuiShengTec.utils.Toolkit;

/**
 * 条形码
 * 
 * @author mihuajun
 * @createTime 2014-11-13 下午4:12:05
 */

@Controller
public class BarCode{

	@RequestMapping("getBarCode")
	@ResponseBody
	public void generateBarCode(HttpServletResponse response,String code) throws Exception {

		if (Toolkit.isEmpty(code))
			return;
		
		/**
		 *  EAN13, EAN8, UPCA, UPCE, Code 3 of 9, Codabar, Code 11
		 *  , Code 93, Code 128, MSI/Plessey, Interleaved 2 of PostNet等
		 */
		
		JBarcode localJBarcode = new JBarcode(Code11Encoder.getInstance(), WidthCodedPainter.getInstance(),new TextPainter() {
			@Override
			public void paintText(BufferedImage arg0, String arg1, int arg2) {
			}
		});
		
		BufferedImage localBufferedImage = localJBarcode.createBarcode(code.trim());
		response.setContentType("image/gif");
		OutputStream os = response.getOutputStream();
		ImageIO.write(localBufferedImage, "gif", os);
	}
}
