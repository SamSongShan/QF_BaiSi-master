package com.example.song.baisi.jinghua;

import java.util.List;

/**
 * Created by 11355 on 2016/12/6.
 */

public class Precmts1Entity {


    /**
     * normal : {"list":[{"precmts":[{"status":0,"ctime":"2016-12-05T22: 06: 37","data_id":22455798,"floor":1,"content":"那狗刚吃过屎","like_count":592,"user":{"username":"用户464177","qq_uid":"","profile_image":"http: //qzapp.qlogo.cn/qzapp/100336987/52DC67361DB237F2B845FADD42DAC8AF/100","weibo_uid":"","personal_page":"http: //user.qzone.qq.com/52DC67361DB237F2B845FADD42DAC8AF","room_name":"","room_role":"","total_cmt_like_count":"695","is_vip":false,"room_url":"","qzone_uid":"52DC67361DB237F2B845FADD42DAC8AF","sex":"m","id":14086197,"room_icon":""}}]}]}
     */

    private NormalEntity normal;

    public NormalEntity getNormal() {
        return normal;
    }

    public void setNormal(NormalEntity normal) {
        this.normal = normal;
    }

    public static class NormalEntity {
        private List<ListEntity> list;

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            private List<PrecmtsEntity> precmts;

            public List<PrecmtsEntity> getPrecmts() {
                return precmts;
            }

            public void setPrecmts(List<PrecmtsEntity> precmts) {
                this.precmts = precmts;
            }

            public static class PrecmtsEntity {
                /**
                 * status : 0
                 * ctime : 2016-12-05T22: 06: 37
                 * data_id : 22455798
                 * floor : 1
                 * content : 那狗刚吃过屎
                 * like_count : 592
                 * user : {"username":"用户464177","qq_uid":"","profile_image":"http: //qzapp.qlogo.cn/qzapp/100336987/52DC67361DB237F2B845FADD42DAC8AF/100","weibo_uid":"","personal_page":"http: //user.qzone.qq.com/52DC67361DB237F2B845FADD42DAC8AF","room_name":"","room_role":"","total_cmt_like_count":"695","is_vip":false,"room_url":"","qzone_uid":"52DC67361DB237F2B845FADD42DAC8AF","sex":"m","id":14086197,"room_icon":""}
                 */

                private int status;
                private String ctime;
                private int data_id;
                private int floor;
                private String content;
                private int like_count;
                private UserEntity user;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCtime() {
                    return ctime;
                }

                public void setCtime(String ctime) {
                    this.ctime = ctime;
                }

                public int getData_id() {
                    return data_id;
                }

                public void setData_id(int data_id) {
                    this.data_id = data_id;
                }

                public int getFloor() {
                    return floor;
                }

                public void setFloor(int floor) {
                    this.floor = floor;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getLike_count() {
                    return like_count;
                }

                public void setLike_count(int like_count) {
                    this.like_count = like_count;
                }

                public UserEntity getUser() {
                    return user;
                }

                public void setUser(UserEntity user) {
                    this.user = user;
                }

                public static class UserEntity {
                    /**
                     * username : 用户464177
                     * qq_uid :
                     * profile_image : http: //qzapp.qlogo.cn/qzapp/100336987/52DC67361DB237F2B845FADD42DAC8AF/100
                     * weibo_uid :
                     * personal_page : http: //user.qzone.qq.com/52DC67361DB237F2B845FADD42DAC8AF
                     * room_name :
                     * room_role :
                     * total_cmt_like_count : 695
                     * is_vip : false
                     * room_url :
                     * qzone_uid : 52DC67361DB237F2B845FADD42DAC8AF
                     * sex : m
                     * id : 14086197
                     * room_icon :
                     */

                    private String username;
                    private String qq_uid;
                    private String profile_image;
                    private String weibo_uid;
                    private String personal_page;
                    private String room_name;
                    private String room_role;
                    private String total_cmt_like_count;
                    private boolean is_vip;
                    private String room_url;
                    private String qzone_uid;
                    private String sex;
                    private int id;
                    private String room_icon;

                    public String getUsername() {
                        return username;
                    }

                    public void setUsername(String username) {
                        this.username = username;
                    }

                    public String getQq_uid() {
                        return qq_uid;
                    }

                    public void setQq_uid(String qq_uid) {
                        this.qq_uid = qq_uid;
                    }

                    public String getProfile_image() {
                        return profile_image;
                    }

                    public void setProfile_image(String profile_image) {
                        this.profile_image = profile_image;
                    }

                    public String getWeibo_uid() {
                        return weibo_uid;
                    }

                    public void setWeibo_uid(String weibo_uid) {
                        this.weibo_uid = weibo_uid;
                    }

                    public String getPersonal_page() {
                        return personal_page;
                    }

                    public void setPersonal_page(String personal_page) {
                        this.personal_page = personal_page;
                    }

                    public String getRoom_name() {
                        return room_name;
                    }

                    public void setRoom_name(String room_name) {
                        this.room_name = room_name;
                    }

                    public String getRoom_role() {
                        return room_role;
                    }

                    public void setRoom_role(String room_role) {
                        this.room_role = room_role;
                    }

                    public String getTotal_cmt_like_count() {
                        return total_cmt_like_count;
                    }

                    public void setTotal_cmt_like_count(String total_cmt_like_count) {
                        this.total_cmt_like_count = total_cmt_like_count;
                    }

                    public boolean isIs_vip() {
                        return is_vip;
                    }

                    public void setIs_vip(boolean is_vip) {
                        this.is_vip = is_vip;
                    }

                    public String getRoom_url() {
                        return room_url;
                    }

                    public void setRoom_url(String room_url) {
                        this.room_url = room_url;
                    }

                    public String getQzone_uid() {
                        return qzone_uid;
                    }

                    public void setQzone_uid(String qzone_uid) {
                        this.qzone_uid = qzone_uid;
                    }

                    public String getSex() {
                        return sex;
                    }

                    public void setSex(String sex) {
                        this.sex = sex;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getRoom_icon() {
                        return room_icon;
                    }

                    public void setRoom_icon(String room_icon) {
                        this.room_icon = room_icon;
                    }
                }
            }
        }
    }
}
