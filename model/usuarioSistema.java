����   4 [
  H	  I	  J	  K	  L
  M
  N
  O
  P
  Q
  R
  S
  T
  U
  V
  W X Y nombreUsuario Ljava/lang/String; nombreVisualizado 
privilegio Lmodel/privilegio; contraseña Lsun/security/util/Password; <init> ()V Code LineNumberTable LocalVariableTable this Lmodel/usuarioSistema; U(Ljava/lang/String;Ljava/lang/String;Lmodel/privilegio;Lsun/security/util/Password;)V �(Ljava/lang/String;Ljava/lang/String;Lmodel/privilegio;Lsun/security/util/Password;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmodel/Sexo;Lmodel/estadoCivil;)V 	nroCedula nombreCompleto edad sexo Lmodel/Sexo; estadoCivil Lmodel/estadoCivil; getNombreUsuario ()Ljava/lang/String; setNombreUsuario (Ljava/lang/String;)V getNombreVisualizado setNombreVisualizado getPrivilegio ()Lmodel/privilegio; setPrivilegio (Lmodel/privilegio;)V getContraseña ()Lsun/security/util/Password; setContraseña (Lsun/security/util/Password;)V setEstadoCivil (Lmodel/estadoCivil;)V getEstadoCivil ()Lmodel/estadoCivil; setSexo (Lmodel/Sexo;)V getSexo ()Lmodel/Sexo; setEdad getEdad setNombreCompleto getNombreCompleto setNroCedula getNroCedula 
SourceFile usuarioSistema.java            Z 8 9 : ; < = > ? @ - A + B - C + D - E + model/usuarioSistema model/persona X(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmodel/Sexo;Lmodel/estadoCivil;)V !                                  3     *� �       
                      !     �     *� *+� *,� *-� *� �              	           4                                    "     �  
   $*	� *+� *,� *-� *� �                    #     f 
   $        $      $      $      $      $ #     $ $     $ %     $ & '    $ ( ) 	  * +     /     *� �                           , -     >     *+� �       
    $  %                     . +     /     *� �           (               / -     >     *+� �       
    ,  -                     0 1     /     *� �           0               2 3     >     *+� �       
    4  5                     4 5     /     *� �           8               6 7     >     *+� �       
    <  =                   A 8 9     0     *+� �                        A : ;     /     *� �                        A < =     0     *+� 	�                        A > ?     /     *� 
�                        A @ -     0     *+� �                        A A +     /     *� �                        A B -     0     *+� �                        A C +     /     *� �                        A D -     0     *+� �                        A E +     /     *� �                          F    G