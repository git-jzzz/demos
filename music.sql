/*
 Navicat Premium Data Transfer

 Source Server         : dockerMysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3307
 Source Schema         : audio

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 16/01/2021 15:27:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `song_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌曲名',
  `song_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `song_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌曲url',
  `lrc_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌词url',
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面url',
  `status` int NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, 'Dancing With Your Ghost', 'Sasha Sloan', 'http://qny.jzai.xyz/Dancing With Your Ghost-Sasha Sloan.mp3', 'http://qny.jzai.xyz/Dancing With Your Ghost-Sasha Sloan.lrc', 'http://qny.jzai.xyz/Dancing With Your Ghost-Sasha Sloan.jpg', 1);
INSERT INTO `music` VALUES (2, 'ＡＬＯＮＥ', 'TRA$H', 'http://qny.jzai.xyz/ＡＬＯＮＥ-TRA$H.mp3', 'http://qny.jzai.xyz/ＡＬＯＮＥ-TRA$H.lrc', 'http://qny.jzai.xyz/ＡＬＯＮＥ-TRA$H.jpg', 1);
INSERT INTO `music` VALUES (3, 'LOSER', '米津玄師', 'http://qny.jzai.xyz/LOSER-米津玄師.mp3', 'http://qny.jzai.xyz/LOSER-米津玄師.lrc', 'http://qny.jzai.xyz/LOSER-米津玄師.jpg', 1);
INSERT INTO `music` VALUES (4, '你若成风', '许嵩', 'http://qny.jzai.xyz/你若成风-许嵩.mp3', 'http://qny.jzai.xyz/你若成风-许嵩.lrc', 'http://qny.jzai.xyz/你若成风-许嵩.jpg', 1);
INSERT INTO `music` VALUES (5, 'Better Now', 'Yuna', 'http://qny.jzai.xyz/Better Now-Yuna.mp3', 'http://qny.jzai.xyz/Better Now-Yuna.lrc', 'http://qny.jzai.xyz/Better Now-Yuna.jpg', 1);
INSERT INTO `music` VALUES (6, 'Let Me Down Slowly ', 'Beth', 'http://qny.jzai.xyz/Let Me Down Slowly -Beth.mp3', 'http://qny.jzai.xyz/Let Me Down Slowly -Beth.lrc', 'http://qny.jzai.xyz/Let Me Down Slowly -Beth.jpg', 1);
INSERT INTO `music` VALUES (7, 'LoveisGone', 'SLANDER  Dylan Matthew', 'http://qny.jzai.xyz/LoveisGone-SLANDER  Dylan Matthew.mp3', 'http://qny.jzai.xyz/LoveisGone-SLANDER  Dylan Matthew.lrc', 'http://qny.jzai.xyz/LoveisGone-SLANDER  Dylan Matthew.jpg', 1);
INSERT INTO `music` VALUES (8, '卡农（经典钢琴版）', 'dylanf', 'http://qny.jzai.xyz/卡农（经典钢琴版）-dylanf.mp3', 'http://qny.jzai.xyz/卡农（经典钢琴版）-dylanf.lrc', 'http://qny.jzai.xyz/卡农（经典钢琴版）-dylanf.jpg', 1);
INSERT INTO `music` VALUES (9, 'Send It', 'Alexi Noa', 'http://qny.jzai.xyz/Send It-Alexi Noa.mp3', 'http://qny.jzai.xyz/Send It-Alexi Noa.lrc', 'http://qny.jzai.xyz/Send It-Alexi Noa.jpg', 1);
INSERT INTO `music` VALUES (10, 'Nothing On You', 'B.o.B  Bruno Mars', 'http://qny.jzai.xyz/Nothing On You-B.o.B  Bruno Mars.mp3', 'http://qny.jzai.xyz/Nothing On You-B.o.B  Bruno Mars.lrc', 'http://qny.jzai.xyz/Nothing On You-B.o.B  Bruno Mars.jpg', 1);
INSERT INTO `music` VALUES (11, 'Sold Out', 'Hawk Nelson', 'http://qny.jzai.xyz/Sold Out-Hawk Nelson.mp3', 'http://qny.jzai.xyz/Sold Out-Hawk Nelson.lrc', 'http://qny.jzai.xyz/Sold Out-Hawk Nelson.jpg', 1);
INSERT INTO `music` VALUES (12, 'Umbrella (Matte Remix)', 'Matte  Ember Island', 'http://qny.jzai.xyz/Umbrella (Matte Remix)-Matte  Ember Island.mp3', 'http://qny.jzai.xyz/Umbrella (Matte Remix)-Matte  Ember Island.lrc', 'http://qny.jzai.xyz/Umbrella (Matte Remix)-Matte  Ember Island.jpg', 1);
INSERT INTO `music` VALUES (13, 'Lemon Tree', 'Fool\'s Garden', 'http://qny.jzai.xyz/Lemon Tree-Fool\'s Garden.mp3', 'http://qny.jzai.xyz/Lemon Tree-Fool\'s Garden.lrc', 'http://qny.jzai.xyz/Lemon Tree-Fool\'s Garden.jpg', 1);
INSERT INTO `music` VALUES (14, 'The Way I Still Love You', 'Reynard /Silva', 'http://qny.jzai.xyz/The Way I Still Love You-Reynard Silva.mp3', 'http://qny.jzai.xyz/The Way I Still Love You-Reynard Silva.lrc', 'http://qny.jzai.xyz/The Way I Still Love You-Reynard Silva.jpg', 1);
INSERT INTO `music` VALUES (15, 'My beautiful', 'Davin大文  小郭雨儿', 'http://qny.jzai.xyz/My beautiful-Davin大文  小郭雨儿.mp3', 'http://qny.jzai.xyz/My beautiful-Davin大文  小郭雨儿.lrc', 'http://qny.jzai.xyz/My beautiful-Davin大文  小郭雨儿.jpg', 1);
INSERT INTO `music` VALUES (16, 'Natural', 'Planet in Limbo', 'http://qny.jzai.xyz/Natural-Planet in Limbo.mp3', 'http://qny.jzai.xyz/Natural-Planet in Limbo.lrc', 'http://qny.jzai.xyz/Natural-Planet in Limbo.jpg', 1);
INSERT INTO `music` VALUES (17, 'Dusk Till Dawn', 'ZAYN  Sia', 'http://qny.jzai.xyz/Dusk Till Dawn-ZAYN  Sia.mp3', 'http://qny.jzai.xyz/Dusk Till Dawn-ZAYN  Sia.lrc', 'http://qny.jzai.xyz/Dusk Till Dawn-ZAYN  Sia.jpg', 1);
INSERT INTO `music` VALUES (18, 'YELLOW', '神山羊', 'http://qny.jzai.xyz/YELLOW-神山羊.mp3', 'http://qny.jzai.xyz/YELLOW-神山羊.lrc', 'http://qny.jzai.xyz/YELLOW-神山羊.jpg', 1);
INSERT INTO `music` VALUES (19, 'Too Far', 'Anna F', 'http://qny.jzai.xyz/Too Far-Anna F.mp3', 'http://qny.jzai.xyz/Too Far-Anna F.lrc', 'http://qny.jzai.xyz/Too Far-Anna F.jpg', 1);
INSERT INTO `music` VALUES (20, '50 Feet', 'SoMo', 'http://qny.jzai.xyz/50 Feet-SoMo.mp3', 'http://qny.jzai.xyz/50 Feet-SoMo.lrc', 'http://qny.jzai.xyz/50 Feet-SoMo.jpg', 1);
INSERT INTO `music` VALUES (21, 'Galway Girl', 'MADILYN', 'http://qny.jzai.xyz/Galway Girl-MADILYN.mp3', 'http://qny.jzai.xyz/Galway Girl-MADILYN.lrc', 'http://qny.jzai.xyz/Galway Girl-MADILYN.jpg', 1);
INSERT INTO `music` VALUES (22, 'Coming Home', 'Skylar Grey  Diddy-Dirty Money', 'http://qny.jzai.xyz/Coming Home-Skylar Grey  Diddy-Dirty Money.mp3', 'http://qny.jzai.xyz/Coming Home-Skylar Grey  Diddy-Dirty Money.lrc', 'http://qny.jzai.xyz/Coming Home-Skylar Grey  Diddy-Dirty Money.jpg', 1);
INSERT INTO `music` VALUES (23, 'We Can\'t Stop', 'Boyce Avenue  Bea Miller', 'http://qny.jzai.xyz/We Can\'t Stop-Boyce Avenue  Bea Miller.mp3', 'http://qny.jzai.xyz/We Can\'t Stop-Boyce Avenue  Bea Miller.lrc', 'http://qny.jzai.xyz/We Can\'t Stop-Boyce Avenue  Bea Miller.jpg', 1);
INSERT INTO `music` VALUES (24, 'MELANCHOLY', 'White Cherry', 'http://qny.jzai.xyz/MELANCHOLY-White Cherry.mp3', 'http://qny.jzai.xyz/MELANCHOLY-White Cherry.lrc', 'http://qny.jzai.xyz/MELANCHOLY-White Cherry.jpg', 1);
INSERT INTO `music` VALUES (25, 'Valder Fields', 'Tamas Wells', 'http://qny.jzai.xyz/Valder Fields-Tamas Wells.mp3', 'http://qny.jzai.xyz/Valder Fields-Tamas Wells.lrc', 'http://qny.jzai.xyz/Valder Fields-Tamas Wells.jpg', 1);
INSERT INTO `music` VALUES (26, 'Girls Like You（toby randall）', 'AGAM', 'http://qny.jzai.xyz/Girls Like You（toby randall）-AGAM.mp3', 'http://qny.jzai.xyz/Girls Like You（toby randall）-AGAM.lrc', 'http://qny.jzai.xyz/Girls Like You（toby randall）-AGAM.jpg', 1);
INSERT INTO `music` VALUES (27, '椿', '沈以诚', 'http://qny.jzai.xyz/椿-沈以诚.mp3', 'http://qny.jzai.xyz/椿-沈以诚.lrc', 'http://qny.jzai.xyz/椿-沈以诚.jpg', 1);
INSERT INTO `music` VALUES (28, '晴天', '周杰伦', 'http://qny.jzai.xyz/晴天-周杰伦.mp3', 'http://qny.jzai.xyz/晴天-周杰伦.lrc', 'http://qny.jzai.xyz/晴天-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (29, '七里香', '周杰伦', 'http://qny.jzai.xyz/七里香-周杰伦.mp3', 'http://qny.jzai.xyz/七里香-周杰伦.lrc', 'http://qny.jzai.xyz/七里香-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (30, '以父之名', '周杰伦', 'http://qny.jzai.xyz/以父之名-周杰伦.mp3', 'http://qny.jzai.xyz/以父之名-周杰伦.lrc', 'http://qny.jzai.xyz/以父之名-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (31, '稻香', '周杰伦', 'http://qny.jzai.xyz/稻香-周杰伦.mp3', 'http://qny.jzai.xyz/稻香-周杰伦.lrc', 'http://qny.jzai.xyz/稻香-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (32, '告白气球', '周杰伦', 'http://qny.jzai.xyz/告白气球-周杰伦.mp3', 'http://qny.jzai.xyz/告白气球-周杰伦.lrc', 'http://qny.jzai.xyz/告白气球-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (33, '听妈妈的话', '周杰伦', 'http://qny.jzai.xyz/听妈妈的话-周杰伦.mp3', 'http://qny.jzai.xyz/听妈妈的话-周杰伦.lrc', 'http://qny.jzai.xyz/听妈妈的话-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (34, '彩虹(电影《命运呼叫转移》片尾曲)', '周杰伦', 'http://qny.jzai.xyz/彩虹(电影《命运呼叫转移》片尾曲)-周杰伦.mp3', 'http://qny.jzai.xyz/彩虹(电影《命运呼叫转移》片尾曲)-周杰伦.lrc', 'http://qny.jzai.xyz/彩虹(电影《命运呼叫转移》片尾曲)-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (35, '夜的第七章', '周杰伦', 'http://qny.jzai.xyz/夜的第七章-周杰伦.mp3', 'http://qny.jzai.xyz/夜的第七章-周杰伦.lrc', 'http://qny.jzai.xyz/夜的第七章-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (36, '说好的幸福呢', '周杰伦', 'http://qny.jzai.xyz/说好的幸福呢-周杰伦.mp3', 'http://qny.jzai.xyz/说好的幸福呢-周杰伦.lrc', 'http://qny.jzai.xyz/说好的幸福呢-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (37, '烟花易冷', '周杰伦', 'http://qny.jzai.xyz/烟花易冷-周杰伦.mp3', 'http://qny.jzai.xyz/烟花易冷-周杰伦.lrc', 'http://qny.jzai.xyz/烟花易冷-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (38, '夜曲', '周杰伦', 'http://qny.jzai.xyz/夜曲-周杰伦.mp3', 'http://qny.jzai.xyz/夜曲-周杰伦.lrc', 'http://qny.jzai.xyz/夜曲-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (39, '青花瓷', '周杰伦', 'http://qny.jzai.xyz/青花瓷-周杰伦.mp3', 'http://qny.jzai.xyz/青花瓷-周杰伦.lrc', 'http://qny.jzai.xyz/青花瓷-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (40, '明明就', '周杰伦', 'http://qny.jzai.xyz/明明就-周杰伦.mp3', 'http://qny.jzai.xyz/明明就-周杰伦.lrc', 'http://qny.jzai.xyz/明明就-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (41, '龙卷风', '周杰伦', 'http://qny.jzai.xyz/龙卷风-周杰伦.mp3', 'http://qny.jzai.xyz/龙卷风-周杰伦.lrc', 'http://qny.jzai.xyz/龙卷风-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (42, '黑色毛衣', '周杰伦', 'http://qny.jzai.xyz/黑色毛衣-周杰伦.mp3', 'http://qny.jzai.xyz/黑色毛衣-周杰伦.lrc', 'http://qny.jzai.xyz/黑色毛衣-周杰伦.jpg', 1);
INSERT INTO `music` VALUES (43, '起风了', '买辣椒也用券', 'http://qny.jzai.xyz/起风了-买辣椒也用券.mp3', 'http://qny.jzai.xyz/起风了-买辣椒也用券.lrc', 'http://qny.jzai.xyz/起风了-买辣椒也用券.jpg', 1);
INSERT INTO `music` VALUES (44, '处处吻', '杨千嬅', 'http://qny.jzai.xyz/处处吻-杨千嬅.mp3', 'http://qny.jzai.xyz/处处吻-杨千嬅.lrc', 'http://qny.jzai.xyz/处处吻-杨千嬅.jpg', 1);
INSERT INTO `music` VALUES (45, '世界这么大还是遇见你', '程响', 'http://qny.jzai.xyz/世界这么大还是遇见你-程响.mp3', 'http://qny.jzai.xyz/世界这么大还是遇见你-程响.lrc', 'http://qny.jzai.xyz/世界这么大还是遇见你-程响.jpg', 1);

SET FOREIGN_KEY_CHECKS = 1;
