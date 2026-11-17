#pragma once
#include <string>

namespace i18n {
struct LangInfo { const char* code; const char* name; };

const LangInfo* languages(int& count);

void setLanguage(const std::string& pref, const std::string& sys);

std::string current();

std::string tr(const std::string& s);

const char* T(const char* s);
}

#define T(s) i18n::T(s)
